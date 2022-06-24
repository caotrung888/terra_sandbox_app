plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("SmartPosApplicationPlugin") {
            id = "smart-pos-application"
            implementationClass = "plugins.SmartPosApplicationPlugin"
        }

        register("SharedAndroidLibraryPlugin") {
            id = "shared-android-library"
            implementationClass = "plugins.SharedAndroidLibraryPlugin"
        }

        register("SharedKotlinLibraryPlugin") {
            id = "shared-kotlin-library"
            implementationClass = "plugins.SharedKotlinLibraryPlugin"
        }

        register("SharedJavaLibraryPlugin") {
            id = "shared-java-library"
            implementationClass = "plugins.SharedJavaLibraryPlugin"
        }

        register("SharedAndroidDynamicModulePlugin") {
            id = "shared-android-dynamic-module"
            implementationClass = "plugins.SharedAndroidDynamicModulePlugin"
        }

        register("SharedAndroidMPPLibraryPlugin") {
            id = "shared-android-mpp-library"
            implementationClass = "plugins.SharedAndroidMPPLibraryPlugin"
        }

        register("SharedJavaPlatformPlugin") {
            id = "shared-java-platform"
            implementationClass = "plugins.SharedJavaPlatformPlugin"
        }
    }
}

object PluginsVersions {
    const val GRADLE_ANDROID = "7.0.2"
    const val KOTLIN = "1.5.31"
    const val GRADLE_SQL_DELIGHT = "1.5.1"
    const val GSON = "2.8.9"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
    implementation("org.jetbrains.kotlin:kotlin-serialization:${PluginsVersions.KOTLIN}")
    implementation("com.squareup.sqldelight:gradle-plugin:${PluginsVersions.GRADLE_SQL_DELIGHT}")
    implementation("com.google.code.gson:gson:${PluginsVersions.GSON}")
}