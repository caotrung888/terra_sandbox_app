import extensions.gitlabTeko
import extensions.googleArtifactsRegistryTeko

buildscript {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://maven.fabric.io/public")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${BuildDependenciesVersions.GRADLE}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${BuildDependenciesVersions.NAVIGATION}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("com.google.gms:google-services:${BuildDependenciesVersions.GOOGLE_SERVICES}")
        classpath("junit:junit:${BuildDependenciesVersions.JUNIT}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        gitlabTeko(
            project = this@allprojects,
            uri = "https://git.teko.vn/api/v4/projects/1782/packages/maven"
        )
        googleArtifactsRegistryTeko(project = this@allprojects)

        maven {
            // Android JSC is installed from npm
            url =
                uri("$rootDir/react-native-example/node_modules/jsc-android/dist")
        }
        maven {
            // All of React Native (JS, Obj-C sources, Android binaries) is installed from npm
            url =
                uri("$rootDir/react-native-example/node_modules/react-native/android")
        }

    }

    ext {
        set("terraBom", "4.0.0-alpha9")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
