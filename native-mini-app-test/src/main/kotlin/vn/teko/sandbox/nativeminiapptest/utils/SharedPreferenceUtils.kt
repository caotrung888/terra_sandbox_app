package vn.teko.sandbox.nativeminiapptest.utils

import android.content.Context

/**
 * Created by TrungCS on 26/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
internal object SharedPreferenceUtils {
    private const val SANDBOX_SHARED_PREFERENCE = "sandboxSharedPreference"
    private const val SANDBOX_SCENARIO_TYPE_KEY = "scenarioType"

    fun getSavedDropdownPosition(context: Context): Int {
        val sharedPreferences =
            context.getSharedPreferences(SANDBOX_SHARED_PREFERENCE, Context.MODE_PRIVATE)

        return sharedPreferences.getInt(SANDBOX_SCENARIO_TYPE_KEY, 0)
    }
}