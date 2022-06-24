package extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.api.artifacts.repositories.PasswordCredentials
import org.gradle.api.credentials.HttpHeaderCredentials
import org.gradle.authentication.http.BasicAuthentication
import org.gradle.authentication.http.HttpHeaderAuthentication
import org.gradle.internal.credentials.DefaultPasswordCredentials

fun MavenArtifactRepository.configureCredential(project: Project, uri: String) {
  when (getPackageRegistryType(uri)) {
    PackageRegistryType.Github -> configureGithubCredential(project)
    PackageRegistryType.Gitlab -> configureGitlabCredential(project)
    PackageRegistryType.GoogleRegistry -> configureGoogleRegistryCredential(project)
  }
}

private fun MavenArtifactRepository.configureGithubCredential(project: Project) {
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

private fun MavenArtifactRepository.configureGitlabCredential(project: Project) {
  credentials(HttpHeaderCredentials::class.java) {
    try {
      val privateToken = project.getGitlabProperty("privateToken")
      name = "Private-Token"
      value = privateToken
    } catch (error: NoSuchFieldException) {
      name = "Job-Token"
      value = System.getenv("CI_JOB_TOKEN")
    }

  }
  authentication {
    create("header", HttpHeaderAuthentication::class.java)
  }
}

private fun MavenArtifactRepository.configureGoogleRegistryCredential(project: Project) {
  credentials(PasswordCredentials::class.java) {
    try {
      val secret = project.getGoogleRegistryProperty("artifactRegistryMavenSecret")
      username = "_json_key_base64"
      password = secret
    } catch (error: NoSuchFieldException) {
      // for CI build
      username = "_json_key_base64"
      password = System.getenv("GOOGLE_REGISTRY_CREDENTIAL")
    }
  }
  authentication {
    create("header", BasicAuthentication::class.java)
  }
}