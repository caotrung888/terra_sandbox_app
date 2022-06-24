package plugins

import BuildAndroidConfig
import BuildPlugins
import com.android.build.gradle.LibraryExtension
import extensions.configMavenPublishing
import extensions.getModuleVersion
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

/**
 * Gradle plugin implemented by [SharedAndroidLibraryPlugin].
 *
 * @see [SharedAndroidLibraryPlugin]
 */
inline val PluginDependenciesSpec.`shared-java-platform`: PluginDependencySpec
    get() = id("shared-java-platform")

class SharedJavaPlatformPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        project.group = BuildAndroidConfig.GROUP
        project.version = target.getModuleVersion()

        configPlatform()
        if (!BuildAndroidConfig.PUBLISH_EXCLUSIONS.contains(project.name)) {
            if (BuildAndroidConfig.REPO_TYPE == "framework") {
                if (project.name == "app")
                    configMavenPublishing(listOf("production"))
                else
                    configMavenPublishing()
            }
        }
    }

    private fun Project.configPlatform() = run {
        apply(plugin = BuildPlugins.JAVA_PLATFORM)
    }
}
