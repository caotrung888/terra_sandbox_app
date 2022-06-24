package dependencies

/**
 * Project annotation processor dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object AnnotationProcessorsDependencies {
    const val ROOM_COMPILER = "androidx.room:room-compiler:${BuildDependenciesVersions.ROOM}"
    const val DAGGER_COMPILER =
        "com.google.dagger:dagger-compiler:${BuildDependenciesVersions.DAGGER}"
    const val DAGGER_ANDROID_PROCESSOR =
        "com.google.dagger:dagger-android-processor:${BuildDependenciesVersions.DAGGER}"
    const val GLIDE_COMPILER =
        "com.github.bumptech.glide:compiler:${BuildDependenciesVersions.GLIDE}"
    const val EPOXY_PROCESSOR =
        "com.airbnb.android:epoxy-processor:${BuildDependenciesVersions.EPOXY}"
    const val MAP_STRUCT_PROCESSOR =
        "org.mapstruct:mapstruct-processor:${BuildDependenciesVersions.MAP_STRUCT}"
    const val MAP_STRUCT_KOTLIN_BUILDER_PROCESSOR =
        "com.github.pozo:mapstruct-kotlin-processor:${BuildDependenciesVersions.MAP_STRUCT_KOTLIN_BUILDER}"

    const val TEKO_AF_PROCESSOR = "vn.teko.android.core:processor:${BuildDependenciesVersions.CORE}"

    const val TEKO_NOTIFICATION_FCM_UTIL_PROCESSOR =
        "vn.teko.notification:fcm-util-processor:${BuildDependenciesVersions.TEKO_NOTIFICATION_FCM_UTIL_PROCESSOR}"

    const val HILT_ANDROID_COMPILER =
        "com.google.dagger:hilt-android-compiler:${BuildDependenciesVersions.HILT}"
    const val HILT_COMPILER =
        "androidx.hilt:hilt-compiler:${BuildDependenciesVersions.HILT_COMPILER}"
}
