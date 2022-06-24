import utils.getProjectPropertyFromFile
import utils.safelyGetProjectPropertyFromFile

/**
 * Configuration of android build
 */
object BuildAndroidConfig {
    private const val filePath: String = "project.properties"

    val USE_PREBUILT_LIBRARIES =
        getProjectPropertyFromFile(filePath, utils.USE_PREBUILT_LIBRARIES).toBoolean()

    val USE_SOME_LOCAL_LIBRARIES =
        safelyGetProjectPropertyFromFile(
            filePath,
            utils.USE_SOME_LOCAL_LIBRARIES,
            "false"
        ).toBoolean()

    val APPLICATION_ID = getProjectPropertyFromFile(filePath, utils.APPLICATION_ID)

    val BUILD_TOOLS_VERSION = getProjectPropertyFromFile(filePath, utils.BUILD_TOOLS_VERSION)
    val COMPILE_SDK_VERSION =
        getProjectPropertyFromFile(filePath, utils.COMPILE_SDK_VERSION).toInt()

    val MIN_SDK_VERSION = getProjectPropertyFromFile(filePath, utils.MIN_SDK_VERSION).toInt()
    val TARGET_SDK_VERSION = getProjectPropertyFromFile(filePath, utils.TARGET_SDK_VERSION).toInt()

    val GROUP = getProjectPropertyFromFile(filePath, utils.GROUP)
    val VERSION_CODE = getProjectPropertyFromFile(filePath, utils.VERSION_CODE).toInt()
    val VERSION_NAME = getProjectPropertyFromFile(filePath, utils.VERSION_NAME)

    val TEST_INSTRUMENTATION_RUNNER =
        getProjectPropertyFromFile(filePath, utils.TEST_INSTRUMENTATION_RUNNER)

    val MULTIDEX_ENABLED = getProjectPropertyFromFile(filePath, utils.MULTIDEX_ENABLED).toBoolean()
    val SUPPORT_VECTOR_DRAWABLE =
        getProjectPropertyFromFile(filePath, utils.SUPPORT_VECTOR_DRAWABLE).toBoolean()

    val IS_MINIFY_RELEASE =
        safelyGetProjectPropertyFromFile(filePath, utils.IS_MINIFY_RELEASE, "false").toBoolean()

    val REPO_TYPE = getProjectPropertyFromFile(filePath, utils.REPO_TYPE)
    val REPO_NAME = getProjectPropertyFromFile(filePath, utils.REPO_NAME)

    val PUBLISH_EXCLUSIONS =
        safelyGetProjectPropertyFromFile(filePath, utils.PUBLISH_EXCLUSIONS, "")

    const val SUPPORT_LIBRARY_VECTOR_DRAWABLES = true
}
