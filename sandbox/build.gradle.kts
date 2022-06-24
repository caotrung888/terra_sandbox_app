import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import dependencies.TekoArtifacts

val terraBomVersion = project.extra.get("terraBom")

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.GOOGLE_SERVICES)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
    buildToolsVersion = BuildAndroidConfig.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
        versionCode = System.getenv("GITHUB_RUN_ID")
            ?.toInt() ?: BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER

        multiDexEnabled = BuildAndroidConfig.MULTIDEX_ENABLED

        vectorDrawables.useSupportLibrary = true
    }

    signingConfigs {
        getByName(BuildType.DEBUG) {
            keyAlias = "debug"
            keyPassword = "12345678"
            storeFile = file("../buildSystem/debug")
            storePassword = "12345678"
        }

        create(BuildType.RELEASE) {
            keyAlias = "debug"
            keyPassword = "12345678"
            storeFile = file("../buildSystem/debug")
            storePassword = "12345678"
        }
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            signingConfig = signingConfigs.getByName(name)

            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
        }

        getByName(BuildType.DEBUG) {
            signingConfig = signingConfigs.getByName(name)

            isMinifyEnabled = false
        }
    }

    flavorDimensions.add(BuildProductDimensions.ENVIRONMENT)

    productFlavors {
        create("dev")
        create("staging")
        create("production")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        dataBinding = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }
}

dependencies {
    implementation(project(":connector"))

    implementation(platform("vn.teko.terra:terra-bom:$terraBomVersion"))

    api(TekoArtifacts.TEKO_AUTH_LOGIN_UI)
    api(TekoArtifacts.TERRA_AUTH)
    api(TekoArtifacts.TERRA_AUTH_GOOGLE_LOGIN)
    api(TekoArtifacts.TERRA_AUTH_FACEBOOK_LOGIN)
    api(TekoArtifacts.TERRA_AUTH_KIT)
    api(TekoArtifacts.TERRA_AUTH_JS_BRIDGE)

    // Payment
    api(TekoArtifacts.TEKO_PAYMENT_CORE_V2)
    api(TekoArtifacts.TEKO_PAYMENT_UI)
    api(TekoArtifacts.TEKO_PAYMENT_MANAGER_V2)

    // Tracker
    api(TekoArtifacts.TEKO_TRACKER_MANAGER)
    api(TekoArtifacts.TEKO_TRACKER_CORE)
    api(TekoArtifacts.TEKO_TRACKER_EVENT)
    api(TekoArtifacts.TEKO_TRACKER_UTIL)

    // Hestia
    api(TekoArtifacts.HESTIA_ANDROID)
    api(TekoArtifacts.TERRA_HESTIA)
    api(TekoArtifacts.HESTIA_ANDROID_WEBAPP)
    api(TekoArtifacts.HESTIA_ANDROID_NATIVE)
    api(TekoArtifacts.HESTIA_ANDROID_REACT_NATIVE)
    api(TekoArtifacts.HESTIA_ANDROID_REACT_NATIVE_UI_FRAGMENT)
    api(TekoArtifacts.HESTIA_KIT_CONNECTOR)

    // Apollo
    api(TekoArtifacts.TEKO_APOLLO)
    api(TekoArtifacts.TERRA_APOLLO)

    // Loyalty
    api(TekoArtifacts.TEKO_LOYALTY_CORE)
    api(TekoArtifacts.TEKO_LOYALTY_MODEL)
    api(TekoArtifacts.TEKO_LOYALTY_TERRA)
    api(TekoArtifacts.TEKO_LOYALTY_CONSUMER_TERRA)
    api(TekoArtifacts.TEKO_LOYALTY_CONSUMER_UI)
    api(TekoArtifacts.TEKO_LOYALTY_COMPONENT)

    // Loyalty
    api(TekoArtifacts.IRIS_CORE)
    api(TekoArtifacts.TERRA_IRIS)

    // Terra
    api(TekoArtifacts.TERRA_CORE)
    api(TekoArtifacts.TERRA_CORE_ANDROID)
    api(TekoArtifacts.TERRA_JS_BRIDGE)
    api(TekoArtifacts.TERRA_JS_BRIDGE_CORE)
    api(TekoArtifacts.TERRA_REACT_NATIVE_BRIDGE)


    implementation(Dependencies.NAVIGATION)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.WORK_MANAGER)
    api(Dependencies.CONSTRAIN_LAYOUT)
    api(Dependencies.MATERIAL_COMPONENTS)
    kapt(AnnotationProcessorsDependencies.DAGGER_COMPILER)
    kapt(AnnotationProcessorsDependencies.DAGGER_ANDROID_PROCESSOR)
}