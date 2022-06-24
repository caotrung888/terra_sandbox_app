import dependencies.TekoArtifacts
import plugins.`shared-android-library`

plugins {
    `shared-android-library`
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.KOTLIN_KAPT)
}

val terraBomVersion = project.extra.get("terraBom")

dependencies {

    // replace your mini-app dependency here
    implementation(project(":native-mini-app-test"))

    implementation(platform("vn.teko.terra:terra-bom:$terraBomVersion"))
    implementation(TekoArtifacts.HESTIA_ANDROID_NATIVE)
}
