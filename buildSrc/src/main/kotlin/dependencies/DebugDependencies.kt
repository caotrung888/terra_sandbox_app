package dependencies

/**
 * Project debug dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object DebugDependencies {
  const val LEAK_CANARY = "com.squareup.leakcanary:leakcanary-android:${BuildDependenciesVersions.LEAK_CANARY}"
  // https://jitpack.io/#amitshekhariitbhu/android-debug-database/v1.0.6
  const val DEBUG_DB = "com.github.amitshekhariitbhu.Android-Debug-Database:debug-db:${BuildDependenciesVersions.DEBUG_DB}"
  const val FRAGMENT_TESTING = "androidx.fragment:fragment-testing:${BuildDependenciesVersions.FRAGMENT}"
}