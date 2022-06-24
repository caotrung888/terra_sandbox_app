package vn.teko.sandbox.utils

import android.content.Context

/**
 * Created by TrungCS on 26/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
object SharedPreferenceUtils {
    private const val SANDBOX_SHARED_PREFERENCE = "sandboxSharedPreference"
    private const val SANDBOX_MINI_APP_TYPE_KEY = "miniAppType"
    private const val SANDBOX_SCENARIO_TYPE_KEY = "scenarioType"
    private const val SANDBOX_APP_CODE_KEY = "appCode"
    private const val SANDBOX_WEB_MINI_APP_URL = "webAppUrl"

    fun getSavedDropdownPosition(context: Context): Triple<Int, Int, String?> {
        val sharedPreferences =
            context.getSharedPreferences(SANDBOX_SHARED_PREFERENCE, Context.MODE_PRIVATE)

        val savedMiniAppPosition = sharedPreferences.getInt(SANDBOX_MINI_APP_TYPE_KEY, 0)
        val savedScenarioPosition = sharedPreferences.getInt(SANDBOX_SCENARIO_TYPE_KEY, 0)
        val savedAppCode = sharedPreferences.getString(SANDBOX_APP_CODE_KEY, null)

        return Triple(savedMiniAppPosition, savedScenarioPosition, savedAppCode)
    }

    fun saveSelectedConfig(
        context: Context,
        miniAppPosition: Int,
        scenarioPosition: Int,
        appCode: String
    ) {
        val sharedPreferences =
            context.getSharedPreferences(SANDBOX_SHARED_PREFERENCE, Context.MODE_PRIVATE)

        sharedPreferences
            .edit()
            .putInt(SANDBOX_MINI_APP_TYPE_KEY, miniAppPosition)
            .putInt(SANDBOX_SCENARIO_TYPE_KEY, scenarioPosition)
            .putString(SANDBOX_APP_CODE_KEY, appCode)
            .apply()
    }

    fun getWebMiniAppUrl(
        context: Context
    ): String {
        val sharedPreferences =
            context.getSharedPreferences(SANDBOX_SHARED_PREFERENCE, Context.MODE_PRIVATE)

        return sharedPreferences.getString(SANDBOX_WEB_MINI_APP_URL, "").orEmpty()
    }

    fun saveWebMiniAppUrl(
        context: Context,
        webMiniAppUrl: String
    ) {
        val sharedPreferences =
            context.getSharedPreferences(SANDBOX_SHARED_PREFERENCE, Context.MODE_PRIVATE)

        sharedPreferences
            .edit()
            .putString(SANDBOX_WEB_MINI_APP_URL, webMiniAppUrl)
            .apply()
    }
}