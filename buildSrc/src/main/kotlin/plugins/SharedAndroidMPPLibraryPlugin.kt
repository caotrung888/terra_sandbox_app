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
import org.gradle.kotlin.dsl.withType
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Gradle plugin implemented by [SharedAndroidLibraryPlugin].
 *
 * @see [SharedAndroidLibraryPlugin]
 */
inline val PluginDependenciesSpec.`shared-android-mpp-library`: PluginDependencySpec
    get() = id("shared-android-mpp-library")

class SharedAndroidMPPLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        project.group = BuildAndroidConfig.GROUP
        project.version = target.getModuleVersion()

        configAndroidLibrary()
        if (!BuildAndroidConfig.PUBLISH_EXCLUSIONS.contains(project.name)) {
            if (BuildAndroidConfig.REPO_TYPE == "framework") {
                configMavenPublishing(listOf("production"))
            }
        }
    }

    private fun Project.configAndroidLibrary() = run {
        apply(plugin = BuildPlugins.ANDROID_LIBRARY)
        apply(plugin = BuildPlugins.KOTLIN_ANDROID)
        apply(plugin = BuildPlugins.KOTLIN_KAPT)
        apply(plugin = BuildPlugins.KOTLIN_PLUGIN_SERIALIZATION)

        android {
            compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
            buildToolsVersion = BuildAndroidConfig.BUILD_TOOLS_VERSION

            defaultConfig {
                minSdk = BuildAndroidConfig.MIN_SDK_VERSION
                targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

                testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
                vectorDrawables.useSupportLibrary =
                    BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES

                consumerProguardFiles("consumer-rules.pro")

                testOptions {
                    android {
                        multiDexEnabled = true
                    }
                }
            }

            buildTypes {
                getByName("release") {
                    proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
                    isMinifyEnabled = BuildAndroidConfig.IS_MINIFY_RELEASE
                }
                getByName("debug") {
                    isMinifyEnabled = false
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
                kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
            }

            buildFeatures {
                dataBinding = true
                viewBinding = true
            }

            sourceSets {
                getByName("main") {
                    java.srcDir("src/main/kotlin")
                }
                getByName("test") {
                    java.setSrcDirs(setOf("src/test/kotlin", "src/sharedTest/kotlin"))
                    resources.setSrcDirs(setOf("src/sharedTestResources"))
                }
                getByName("androidTest") {
                    java.setSrcDirs(setOf("src/androidTest/kotlin", "src/sharedTest/kotlin"))
                    assets.setSrcDirs(setOf("src/sharedTestResources"))
                }
            }
        }
    }

    private fun Project.android(configure: LibraryExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("android", configure)

    private fun Project.publishing(configure: PublishingExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("publishing", configure)

}
