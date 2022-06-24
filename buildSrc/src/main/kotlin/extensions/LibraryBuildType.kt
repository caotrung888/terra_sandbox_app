package extensions

import com.android.build.api.dsl.LibraryBuildType
import org.gradle.api.Project

/**
 * Extension to adds a new string field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the string value of the field
 */
@Suppress("UnstableApiUsage")
fun LibraryBuildType.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
}

/**
 * Extension to adds a new string field to the generated BuildConfig class.
 * Field value is get from local.properties or env variable
 *
 * @param project the current project
 * @param name the name of the field, also name of env variable
 * @param propertyName the name of the local property
 */
@Suppress("UnstableApiUsage")
fun LibraryBuildType.buildSecuredConfigStringField(
    project: Project,
    name: String,
    propertyName: String
) {
    val value = try {
        project.getLocalProperty(propertyName)
    } catch (error: NoSuchFieldException) {
        System.getenv(name)
    }

    buildConfigStringField(name, value)
}

/**
 * Extension to adds a new integer field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the int value of the field
 */
@Suppress("UnstableApiUsage")
fun LibraryBuildType.buildConfigIntField(name: String, value: Int) {
    this.buildConfigField("int", name, value.toString())
}

/**
 * Extension to adds a new boolean field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the boolean value of the field
 */
@Suppress("UnstableApiUsage")
fun LibraryBuildType.buildConfigBooleanField(name: String, value: Boolean) {
    this.buildConfigField("boolean", name, value.toString())
}
