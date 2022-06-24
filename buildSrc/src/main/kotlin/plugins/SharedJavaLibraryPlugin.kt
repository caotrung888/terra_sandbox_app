package plugins

import BuildAndroidConfig
import BuildPlugins
import extensions.configMavenPublishing
import extensions.getModuleVersion
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Gradle plugin implemented by [SharedAndroidLibraryPlugin].
 *
 * @see [SharedAndroidLibraryPlugin]
 */
inline val PluginDependenciesSpec.`shared-java-library`: PluginDependencySpec
    get() = id("shared-java-library")

class SharedJavaLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        project.group = BuildAndroidConfig.GROUP
        project.version = target.getModuleVersion()

        setOutputFileName()

        configJavaLibrary()
        if (BuildAndroidConfig.REPO_TYPE == "framework")
            configMavenPublishing()
    }

    private fun Project.setOutputFileName() = run {
        tasks.withType(Jar::class.java) {
            (this as Jar).run {
                archiveFileName.set("${project.name}.${archiveExtension.get()}")
            }
        }
    }

    private fun Project.configJavaLibrary() = run {
        apply(plugin = BuildPlugins.JAVA_LIBRARY)
        apply(plugin = BuildPlugins.KOTLIN)

        java {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    private fun Project.java(configure: JavaPluginExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("java", configure)

}