package extensions

import BuildPlugins
import dependencies.TekoDependencies
import extensions.PackageRegistryType.*
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.publish.PublicationContainer
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get

private const val DEFAULT_BUILD_TASK_NAME = "bundleReleaseAar"

/**
 * Obtain property declared on `$projectRoot/local.properties` file. Will crash gradle if properties not found.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String): String =
    utils.getLocalProperty(this, propertyName)

/**
 * Obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getLocalProperty(propertyName: String, defaultValue: String): String =
    try {
        utils.getLocalProperty(this, propertyName)
    } catch (error: NoSuchFieldException) {
        defaultValue
    }

/**
 * Obtain property declared on `$projectRoot/local.properties` file or from ENV
 *
 * @param propertyName the name of declared property
 * @param envVariableName the name of declared environment variable
 */
fun Project.getSecuredLocalProperty(propertyName: String, envVariableName: String): String =
    try {
        utils.getLocalProperty(this, propertyName)
    } catch (error: NoSuchFieldException) {
        System.getenv(envVariableName)
    }

/**
 * Obtain property declared on `$projectRoot/github.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getGithubProperty(propertyName: String): String =
    utils.getGithubProperty(this, propertyName)

/**
 * Obtain property declared on `$projectRoot/gitlab.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getGitlabProperty(propertyName: String): String =
    utils.getGitlabProperty(this, propertyName)

/**
 * Obtain property declared on `$projectRoot/google_registry.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getGoogleRegistryProperty(propertyName: String): String =
    utils.getGoogleRegistryProperty(this, propertyName)

/**
 * Obtain property declared on `$projectRoot/github.properties` file or from ENV
 *
 * @param propertyName the name of declared property
 * @param envVariableName the name of declared environment variable
 */
fun Project.getSecuredGithubProperty(propertyName: String, envVariableName: String): String =
    try {
        utils.getGithubProperty(this, propertyName)
    } catch (error: NoSuchFieldException) {
        System.getenv(envVariableName)
    }

/**
 * Obtain property declared on `$projectRoot/project.properties` file.
 *
 * @param propertyName the name of declared property
 */
fun Project.getProjectProperty(propertyName: String): String =
    utils.getProjectProperty(this, propertyName)

/**
 * Obtain property declared on `$projectRoot/project.properties` file or from ENV
 *
 * @param propertyName the name of declared property
 * @param envVariableName the name of declared environment variable
 */
fun Project.getSecuredProjectProperty(propertyName: String, envVariableName: String): String =
    try {
        utils.getProjectProperty(this, propertyName)
    } catch (error: NoSuchFieldException) {
        System.getenv(envVariableName)
    }

/**
 * Obtain property declared on ENV if have or on `$projectRoot/project.properties` file otherwise
 *
 * @param envVariableName the name of declared environment variable
 * @param propertyName the name of declared property
 */
fun Project.getCIProjectProperty(envVariableName: String, propertyName: String): String {
    return try {
        val value = System.getenv(envVariableName)
        if (value.isNullOrBlank())
            utils.getProjectProperty(this, propertyName)
        else
            value
    } catch (error: NoSuchFieldException) {
        ""
    }
}

fun Project.getPropertyFile(fileName: String) =
    utils.getPropertyFile(this, fileName)

private fun Project.publishing(configure: PublishingExtension.() -> Unit): Unit =
    (this as ExtensionAware).extensions.configure("publishing", configure)

fun Project.configMavenPublishing(flavors: List<String> = listOf()) = run {
    apply(plugin = BuildPlugins.MAVEN_PUBLISH)

    val publishFlavor = System.getenv("PUBLISH_FLAVOR")
    val flavorsToPublish = if (publishFlavor.isNullOrBlank()) flavors else listOf(publishFlavor)

    publishing {
        val pubName = project.getProjectProperty("artifactName")
        val uri = project.getProjectProperty("artifactUri")
        val targets = uri.split(",")

        if (flavorsToPublish.isNotEmpty()) {
            flavorsToPublish.forEach { flavor ->
                createMavenPublication(publications, pubName, flavor)
            }
        } else {
            createMavenPublication(publications, pubName, "")
        }

        repositories {
            targets.forEach { target ->
                val repoName = getRepoName(target)

                maven {
                    name = repoName
                    url = uri(target)

                    configureCredential(project, target)
                }
            }
        }
    }
}

fun Project.createMavenPublication(
    publications: PublicationContainer,
    pubName: String,
    flavor: String
) {
    publications.create<MavenPublication>("$pubName$flavor") {
        afterEvaluate {
            groupId = project.group.toString()
            version = project.version.toString()

            if (project.plugins.hasPlugin(BuildPlugins.JAVA_PLATFORM)) {
                createBOMPublication(this@create)
            } else{
                createLibraryPublication(flavor,this@create)
            }

            pom {
                fillGenericDetails(project, Github)
                withXml {
                    collectDependencies(project, flavor)
                }
            }
        }
    }
}

private fun Project.createBOMPublication(publications: MavenPublication) {
    publications.from(components["javaPlatform"])
}

private fun Project.createLibraryPublication(flavor: String, publications: MavenPublication) {
    val buildTask = try {
        val buildTaskName =
            if (project.plugins.findPlugin(BuildPlugins.ANDROID_LIBRARY) != null) {
                "bundle${flavor.capitalize()}ReleaseAar"
            } else {
                "jar"
            }

        tasks[buildTaskName]
    } catch (error: Throwable) {
        tasks[DEFAULT_BUILD_TASK_NAME]
    }

    publications.artifact(buildTask)
}

fun Project.getConfigurationDependencies(configurationName: String): List<Dependency> {
    return try {
        this.configurations[configurationName].allDependencies.toList()
    } catch (exception: Exception) {
        listOf()
    }
}

fun Project.getModuleVersion(): String {
    val publishingModule: String? = System.getenv("PUBLISH_MODULE")
    val ciVersion = System.getenv("PUBLISH_VERSION")

    return if (publishingModule?.endsWith(name) == true && !ciVersion.isNullOrEmpty()) {
        ciVersion
    } else {
        TekoDependencies.getArtifactVersion("${group}:${name}")
    }
}

enum class PackageRegistryType {
    Github,
    Gitlab,
    GoogleRegistry
}

fun getPackageRegistryType(uri: String): PackageRegistryType {
    return when {
        uri.contains("github.com/teko-vn") -> Github
        uri.contains("git.teko.vn") -> Gitlab
        uri.contains("pkg.dev") -> GoogleRegistry
        else -> throw Exception("Invalid maven package registry $uri")
    }
}

private fun getRepoName(uri: String): String {
    return when {
        uri.contains("github.com/teko-vn") -> "TekoGithub"
        uri.contains("git.teko.vn") -> "TekoGitlab"
        uri.contains("pkg.dev") -> "TekoGoogleRegistry"
        else -> throw Exception("Invalid maven package registry $uri")
    }
}

