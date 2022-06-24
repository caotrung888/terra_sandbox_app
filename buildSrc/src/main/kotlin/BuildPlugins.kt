/**
 * Configuration of all gradle build plugins
 */
object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"
    const val ANDROID_DYNAMIC_MODULE = "com.android.dynamic-feature"

    const val JAVA_LIBRARY = "java-library"
    const val JAVA_PLATFORM = "java-platform"
    const val KOTLIN = "kotlin"

    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    const val KOTLIN_PARCELIZE = "kotlin-parcelize"
    const val KOTLIN_MULTIPLATFORM = "org.jetbrains.kotlin.multiplatform"
    const val KOTLIN_KAPT = "kotlin-kapt"

    const val MAVEN_PUBLISH = "maven-publish"
    const val GOOGLE_REGISTRY = "com.google.cloud.artifactregistry.gradle-plugin"

    const val GRGIT = "org.ajoberstar.grgit"
    const val NAVIGATION_SAFE_ARGS = "androidx.navigation.safeargs.kotlin"
    const val IO_FABRIC = "io.fabric"
    const val JACOCO = "jacoco"
    const val GOOGLE_SERVICES = "com.google.gms.google-services"
    const val GOOGLE_CRASHLYTICS = "com.google.firebase.crashlytics"

    const val FIREBASE_PERF = "com.google.firebase.firebase-perf"

    const val KOTLIN_PLUGIN_SERIALIZATION = "org.jetbrains.kotlin.plugin.serialization"
    const val KOTLIN_PLUGIN_PARCELIZE = "org.jetbrains.kotlin.plugin.parcelize"
    
    const val SQL_DELIGHT = "com.squareup.sqldelight"

    const val DAGGER_HILT = "dagger.hilt.android.plugin"
}
