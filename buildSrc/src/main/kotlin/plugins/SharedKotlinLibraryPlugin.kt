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
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.named
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Gradle plugin implemented by [SharedKotlinLibraryPlugin].
 *
 * @see [SharedKotlinLibraryPlugin]
 */
inline val PluginDependenciesSpec.`shared-kotlin-library`: PluginDependencySpec
    get() = id("shared-kotlin-library")

class SharedKotlinLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        project.group = BuildAndroidConfig.GROUP
        project.version = target.getModuleVersion()

        configKotlinLibrary()
        if (BuildAndroidConfig.REPO_TYPE == "framework")
            configMavenPublishing()
    }

    private fun Project.configKotlinLibrary() = run {
        apply(plugin = BuildPlugins.JAVA_LIBRARY)
        apply(plugin = BuildPlugins.KOTLIN)

        java {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }


        tasks.named<Jar>("jar") {
            archiveVersion.set("")
        }
    }

    private fun Project.java(configure: JavaPluginExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("java", configure)

    private fun Project.publishing(configure: PublishingExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("publishing", configure)

}