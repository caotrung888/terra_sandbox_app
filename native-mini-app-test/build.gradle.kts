
plugins {
    id("com.android.library")
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.NAVIGATION_SAFE_ARGS)
    id(BuildPlugins.KOTLIN_KAPT)
}
val terraBomVersion = project.extra.get("terraBom")

android {
    compileSdk = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        minSdk = 19
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

//        consumerProguardFiles("consumer-rules.pro")

        testOptions {
            android {
                multiDexEnabled = true
            }
        }

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = false
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${BuildDependenciesVersions.KOTLIN}")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.vectordrawable:vectordrawable:1.1.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation(platform("vn.teko.terra:terra-bom:$terraBomVersion"))
    implementation("vn.teko.android.payment:payment-kit")

}