package extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.credentials.HttpHeaderCredentials
import org.gradle.authentication.http.BasicAuthentication
import org.gradle.authentication.http.HttpHeaderAuthentication

/**
 * Adds all default repositories used to access to the different declared dependencies
 */
fun RepositoryHandler.applyDefault() {
    google()
    mavenCentral()
}

fun RepositoryHandler.applyReactNativeFromLocal(project: Project, nodeModuleRootPath: String) {
    maven {
        // Android JSC is installed from npm
        url = project.uri("$nodeModuleRootPath/node_modules/jsc-android/dist")
    }
    maven {
        // All of React Native (JS, Obj-C sources, Android binaries) is installed from npm
        url = project.uri("$nodeModuleRootPath/node_modules/react-native/android")
    }
}

fun RepositoryHandler.githubTeko(project: Project) {
    maven {
        name = "TekoGithubPackages"
        url = project.uri("https://maven.pkg.github.com/teko-vn/android-framework")
        // just need to be a random project inside teko-vn, all mavens are linked together so it still can fetch packages from other repos

        credentials {
            username = try {
                project.getGithubProperty("userName")
            } catch (error: NoSuchFieldException) {
                System.getenv("GITHUB_USER_NAME")
            }
            password = try {
                project.getGithubProperty("userToken")
            } catch (error: NoSuchFieldException) {
                System.getenv("GITHUB_USER_TOKEN")
            }
        }
    }
}

fun RepositoryHandler.gitlabTeko(project: Project, uri: String? = null) {
    maven {
        name = "TekoGitlabPackages"
        url = project.uri(uri ?: "https://git.teko.vn/api/v4/groups/924/-/packages/maven")

        credentials(HttpHeaderCredentials::class.java) {
            val privateToken = try {
                project.getGitlabProperty("privateToken")
            } catch (error: NoSuchFieldException) {
                System.getenv("GITLAB_PRIVATE_TOKEN")
            }

            if (privateToken != null) {
                name = "Private-Token"
                value = privateToken
            } else {
                name = "Job-Token"
                value = System.getenv("CI_JOB_TOKEN")
            }

        }
        authentication {
            create("header", HttpHeaderAuthentication::class.java)
        }
    }
}

/**
 * outside Teko will be able to retrieved Teko sdks by using secret key
 */
fun RepositoryHandler.googleArtifactsRegistryTeko(project: Project, uri: String? = null) {
    maven {
        url = project.uri(uri ?: "https://asia-southeast1-maven.pkg.dev/teko-development/teko-mobile-sdks")

        credentials(PasswordCredentials::class.java) {
            val secret = try {
                project.getGoogleRegistryProperty("artifactRegistryMavenSecret")
            } catch (error: NoSuchFieldException) {
                System.getenv("GOOGLE_REGISTRY_CREDENTIAL")
            }

            username = "_json_key_base64"
            password = secret
        }
        authentication {
            create("header", BasicAuthentication::class.java)
        }
    }
}