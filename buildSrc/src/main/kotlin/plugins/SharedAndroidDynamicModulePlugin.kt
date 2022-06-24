package plugins

import BuildAndroidConfig
import BuildPlugins
import com.android.build.gradle.AppExtension
import com.android.build.gradle.internal.dsl.InternalDynamicFeatureExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.withType
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * Gradle plugin implemented by [SharedAndroidDynamicModulePlugin].
 *
 * @see [SharedAndroidDynamicModulePlugin]
 */
inline val PluginDependenciesSpec.`shared-android-dynamic-module`: PluginDependencySpec
    get() = id("shared-android-dynamic-module")

class SharedAndroidDynamicModulePlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        project.group = BuildAndroidConfig.GROUP
        project.version = BuildAndroidConfig.VERSION_NAME

        configAndroidDynamicModule()
    }

    private fun Project.configAndroidDynamicModule() = run {
        apply(plugin = BuildPlugins.ANDROID_DYNAMIC_MODULE)
        apply(plugin = BuildPlugins.KOTLIN_ANDROID)

        android {
            (this as AppExtension).apply {
                compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
                buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

                defaultConfig {
                    minSdk = BuildAndroidConfig.MIN_SDK_VERSION
                    targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

                    versionCode = BuildAndroidConfig.VERSION_CODE
                    versionName = BuildAndroidConfig.VERSION_NAME

                    testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER

                    consumerProguardFiles("consumer-rules.pro")
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
                    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
                }

                sourceSets {
                    getByName("main") {
                        java.srcDir("src/main/java")
                    }
                    getByName("test") {
                        java.srcDir("src/test/java")
                    }
                    getByName("androidTest") {
                        java.srcDir("src/androidTest/java")
                    }
                }
            }

            (this as InternalDynamicFeatureExtension).apply {
                buildFeatures {
                    viewBinding = true
                }
            }
        }
    }

    private fun Project.android(configure: DynamicFeatureExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("android", configure)

}

// WARNING: the correct class to be use for configuring dynamic module is com.android.build.gradle.internal.dsl.DynamicFeatureExtension.
// But idk why this class is internal (so can not be used)... thus I make this Interface here simulating that class
// If errors occur, maybe there are changes in library's internal structure that make this simulation break
interface DynamicFeatureExtension : InternalDynamicFeatureExtension