package extensions

import BuildAndroidConfig
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPom

/**
 * Populates POM with project information
 * These details are shared between all modules in this repository.
 */
fun MavenPom.fillGenericDetails(project: Project, packageRegistryType: PackageRegistryType) {
    val gitUrl = buildGitUrl(packageRegistryType)

    description.set(project.description)
    url.set("https://${gitUrl}")

    developers {
        developer {
            name.set("Mobile Lab")
            email.set("mobile.lab@teko.vn")
            organization.set("Teko")
            organizationUrl.set("https://teko.vn/")
        }
    }
    scm {
        connection.set("scm:git:git://${gitUrl}")
        developerConnection.set("scm:git:ssh://${gitUrl}")
        url.set("https://${gitUrl}")
    }
}

private fun buildGitUrl(packageRegistryType: PackageRegistryType): String {
    return when (packageRegistryType) {
        PackageRegistryType.Github -> "github.com/teko-vn/android-packages.git"
        PackageRegistryType.Gitlab -> "git.teko.vn/sale-channels/mobile-lab/terra-platform/${BuildAndroidConfig.REPO_NAME}.git"
        PackageRegistryType.GoogleRegistry -> "git.teko.vn/sale-channels/mobile-lab/terra-platform/${BuildAndroidConfig.REPO_NAME}.git"
    }
}
