package utils

import org.gradle.api.Project
import java.io.File
import java.util.*

private const val LOCAL_PROPERTIES_FILE_NAME = "local.properties"
private const val GITHUB_PROPERTIES_FILE_NAME = "github.properties"
private const val GITLAB_PROPERTIES_FILE_NAME = "gitlab.properties"
private const val GOOGLE_REGISTRY_PROPERTIES_FILE_NAME = "google_registry.properties"
private const val PROJECT_PROPERTIES_FILE_NAME = "project.properties"

/**
 * Util to obtain property declared on `$projectRoot/local.properties` file.
 *
 * @param project the project reference
 * @param propertyName the name of declared property
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getLocalProperty(project: Project, propertyName: String): String {
    return getPropertyFromFile(project, LOCAL_PROPERTIES_FILE_NAME, propertyName)
}

/**
 * Util to obtain property declared on `$projectRoot/github.properties` file.
 *
 * @param project the project reference
 * @param propertyName the name of declared property
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getGithubProperty(project: Project, propertyName: String): String {
    return getPropertyFromFile(project, GITHUB_PROPERTIES_FILE_NAME, propertyName)
}

/**
 * Util to obtain property declared on `$projectRoot/gitlab.properties` file.
 *
 * @param project the project reference
 * @param propertyName the name of declared property
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getGitlabProperty(project: Project, propertyName: String): String {
    return getPropertyFromFile(project, GITLAB_PROPERTIES_FILE_NAME, propertyName)
}

/**
 * Util to obtain property declared on `$projectRoot/gitlab.properties` file.
 *
 * @param project the project reference
 * @param propertyName the name of declared property
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getGoogleRegistryProperty(project: Project, propertyName: String): String {
    return getPropertyFromFile(project, GOOGLE_REGISTRY_PROPERTIES_FILE_NAME, propertyName)
}

/**
 * Util to obtain property declared on `$projectRoot/project.properties` file.
 *
 * @param project the project reference
 * @param propertyName the name of declared property
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getProjectProperty(project: Project, propertyName: String): String {
    return getPropertyFromFile(project, PROJECT_PROPERTIES_FILE_NAME, propertyName)
}

/**
 * Util to obtain property declared on `$projectRoot/project.properties` file.
 *
 * @param filePath the project.properties file path
 * @param propertyName the name of declared property
 *
 * @return the value of property name, otherwise throw [Exception]
 */
fun getProjectPropertyFromFile(filePath: String, propertyName: String): String {
    val properties = Properties().apply {
        val propertiesFile = File(filePath)
        if (propertiesFile.exists()) {
            load(propertiesFile.inputStream())
        } else throw NoSuchFieldException("Not defined file Name: $filePath")
    }

    return properties.getProperty(propertyName)
        ?: throw NoSuchFieldException("Not defined property: $propertyName")
}

fun safelyGetProjectPropertyFromFile(filePath: String, propertyName: String, defaultValue: String): String {
    return try {
        val properties = Properties().apply {
            val propertiesFile = File(filePath)
            if (propertiesFile.exists()) {
                load(propertiesFile.inputStream())
            } else throw NoSuchFieldException("Not defined file Name: $filePath")
        }

        properties.getProperty(propertyName)
            ?: throw NoSuchFieldException("Not defined property: $propertyName")
    } catch (e: Throwable) {
        defaultValue
    }
}

fun getPropertyFromFile(project: Project, fileName: String, propertyName: String): String {
    val properties = Properties().apply {
        val propertiesFile = project.rootProject.file(fileName)
        if (propertiesFile.exists()) {
            load(propertiesFile.inputStream())
        }
    }

    return properties.getProperty(propertyName)
        ?: throw NoSuchFieldException("Not defined property: $propertyName")
}

fun getPropertyFile(project: Project, fileName: String): Properties {
    return Properties().apply {
        val propertiesFile = project.file(fileName)
        if (propertiesFile.exists()) {
            load(propertiesFile.inputStream())
        }
    }
}
