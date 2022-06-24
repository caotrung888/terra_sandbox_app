package plugins

import BuildAndroidConfig
import BuildModules
import BuildPlugins
import com.android.build.gradle.AppExtension
import dependencies.DebugDependencies
import dependencies.Dependencies
import dependencies.TekoDependencies
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.gradle.kotlin.dsl.withType
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec
import utils.getLocalProperty

/**
 * Gradle plugin implemented by [SmartPosApplicationPlugin].
 *
 * @see [SmartPosApplicationPlugin]
 */
inline val PluginDependenciesSpec.`smart-pos-application`: PluginDependencySpec
    get() = id("smart-pos-application")

class SmartPosApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project): Unit = target.run {
        configApplication()
        configDependencies()
    }

    private fun Project.configApplication() = run {
        apply(plugin = BuildPlugins.ANDROID_APPLICATION)
        apply(plugin = BuildPlugins.KOTLIN_ANDROID)
        apply(plugin = BuildPlugins.KOTLIN_KAPT)

        android {
            compileSdkVersion(BuildAndroidConfig.COMPILE_SDK_VERSION)
            buildToolsVersion(BuildAndroidConfig.BUILD_TOOLS_VERSION)

            defaultConfig {
                minSdk = BuildAndroidConfig.MIN_SDK_VERSION
                targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

                testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER

                vectorDrawables.useSupportLibrary = true

                flavorDimensions(flavors.BuildProductDimensions.ENVIRONMENT)

                multiDexEnabled = BuildAndroidConfig.MULTIDEX_ENABLED

                testOptions {
                    android {
                        multiDexEnabled = true
                    }
                }
            }

            signingConfigs {
                getByName("debug") {
                    keyAlias = "debug"
                    keyPassword = "Abc@123"
                    storeFile = file(this@run.rootDir.absolutePath + "/buildsystem/debug")
                    storePassword = "Abc@123"
                }
                create("release") {
                    keyAlias = try {
                        getLocalProperty(this@run, "signing.key.alias")
                    } catch (error: NoSuchFieldException) {
                        System.getenv("SIGNING_KEY_ALIAS")
                    }
                    keyPassword = try {
                        getLocalProperty(this@run, "signing.key.password")
                    } catch (error: NoSuchFieldException) {
                        System.getenv("SIGNING_KEY_PASSWORD")
                    }
                    storeFile = file(this@run.rootDir.absolutePath + "/buildsystem/release")
                    storePassword = try {
                        getLocalProperty(this@run, "signing.store.password")
                    } catch (error: NoSuchFieldException) {
                        System.getenv("SIGNING_STORE_PASSWORD")
                    }
                }
            }

            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = false
                    isTestCoverageEnabled = System.getenv("TEST_COVERAGE_ENABLED") == "true"
                    signingConfig = signingConfigs.getByName("debug")
                }
                getByName("release") {
                    isDebuggable = false
                    isMinifyEnabled = true
                    isShrinkResources = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                    signingConfig = signingConfigs.getByName("release")
                }
            }

            compileOptions {
                isCoreLibraryDesugaringEnabled = true

                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }

            tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
                kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
            }

            packagingOptions {
                excludes.addAll(
                    arrayOf(
                        "META-INF/*.kotlin_module",
                        "META-INF/spring.tooling",
                        "META-INF/NOTICE.md",
                        "META-INF/spring.handlers",
                        "META-INF/spring-configuration-metadata.json",
                        "META-INF/additional-spring-configuration-metadata.json",
                        "META-INF/spring.factories",
                        "META-INF/spring.schemas",
                        "META-INF/license.txt",
                        "META-INF/notice.txt",
                        "META-INF/LICENSE.md",
                        "META-INF/AL2.0",
                        "META-INF/LGPL2.1"
                    )
                )

                pickFirsts.addAll(
                    arrayOf(
                        "lib/armeabi-v7a/libc++_shared.so",
                        "lib/arm64-v8a/libc++_shared.so",
                        "lib/x86/libc++_shared.so",
                        "lib/x86_64/libc++_shared.so",
                        "lib/x86_64/libfbjni.so",
                        "lib/x86_64/libfolly_futures.so",
                        "lib/arm64-v8a/libjsijniprofiler.so",
                        "lib/arm64-v8a/libhermes-executor-debug.so",
                        "lib/**/*.so"
                    )
                )
            }
        }
    }

    private fun Project.configDependencies() = dependencies {
        add("coreLibraryDesugaring", Dependencies.DESUGAR_JDK_LIBS)
        add("implementation", project(":apps:base"))

        add(
            "implementation", fileTree(
                mapOf(
                    "dir" to "libs",
                    "include" to listOf("*.jar", "*.aar")
                )
            )
        )

        if (BuildAndroidConfig.USE_PREBUILT_LIBRARIES) {
            add("implementation", TekoDependencies.TERRA_CORE_ANDROID)

            // Apollo
            add("implementation", TekoDependencies.TERRA_APOLLO)
        } else {
            add("implementation", project(BuildModules.TERRA_CORE_ANDROID))

            // Apollo
            add("implementation", project(BuildModules.TERRA_APOLLO))
        }

        // for debug only
        add("debugImplementation", DebugDependencies.LEAK_CANARY)
        add("debugImplementation", DebugDependencies.DEBUG_DB)
    }

    private fun Project.android(configure: AppExtension.() -> Unit): Unit =
        (this as ExtensionAware).extensions.configure("android", configure)
}
