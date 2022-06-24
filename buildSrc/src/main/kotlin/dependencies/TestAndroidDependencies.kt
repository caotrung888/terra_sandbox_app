package dependencies

/**
 * Project test android dependencies, makes it easy to include external binaries or
 * other library modules to build.
 */
object TestAndroidDependencies {
  const val JUNIT = "androidx.test.ext:junit:${BuildDependenciesVersions.EXT}"
  const val MOCKITO_ANDROID = "org.mockito:mockito-android:${BuildDependenciesVersions.MOCKITO}"
  const val ESPRESSO =
    "androidx.test.espresso:espresso-core:${BuildDependenciesVersions.ESPRESSO}"

}
