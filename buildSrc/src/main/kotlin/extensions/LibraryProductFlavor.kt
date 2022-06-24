package extensions

import com.android.build.api.dsl.LibraryProductFlavor

/**
 * Extension to adds a new string field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the string value of the field
 */
@Suppress("UnstableApiUsage")
fun LibraryProductFlavor.buildConfigStringField(name: String, value: String) {
    this.buildConfigField("String", name, "\"$value\"")
}

/**
 * Extension to adds a new integer field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the int value of the field
 */
@Suppress("UnstableApiUsage")
fun LibraryProductFlavor.buildConfigIntField(name: String, value: Int) {
    this.buildConfigField("int", name, value.toString())
}

/**
 * Extension to adds a new boolean field to the generated BuildConfig class.
 *
 * @param name the name of the field
 * @param value the boolean value of the field
 */
@Suppress("UnstableApiUsage")
fun LibraryProductFlavor.buildConfigBooleanField(name: String, value: Boolean) {
    this.buildConfigField("boolean", name, value.toString())
}