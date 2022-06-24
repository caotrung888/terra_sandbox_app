package vn.teko.sandbox.connector

import android.app.Application
import android.content.Intent
import vn.teko.hestia.android.model.AppLauncherData
import vn.teko.hestia.android.nativelib.AndroidNativeAppLauncher
import vn.teko.hestia.core.model.authentication.idtoken.IdTokenExchangeAuthResult
import vn.teko.sandbox.nativeminiapptest.DemoMiniAppSdk


/**
 * This is where you can configure data to open your first mini-app screen
 */
internal class NativeConnector : AndroidNativeAppLauncher {

    /**
     * Reconfigure the intent to open your activity here
     * For a simple example: return Intent(application, YourMiniAppActivity::class.java)
     *
     * @param application: Application that was used to open new activity
     * @param launcherData: Containing exchanged token and some extra data that you want to dynamic
     * config your mini-app
     * @return Intent
     */
    override suspend fun create(application: Application, launcherData: AppLauncherData): Intent {
        val authResult = launcherData.authResult as? IdTokenExchangeAuthResult
        val extraConfig = launcherData.extraConfig

        // Place a Intent to open your mini app here
        return DemoMiniAppSdk.createInstance(
            application,
            DemoMiniAppSdk.Config(
                idToken = authResult?.idToken,
                name = getConfigByKey(extraConfig, NAME_KEY),
                address = getConfigByKey(extraConfig, ADDRESS_KEY),
            )
        )
    }

    private fun getConfigByKey(config: Map<String, String>, key: String) = config[key] ?: ""


    companion object {
        private const val NAME_KEY = "name"
        private const val ADDRESS_KEY = "address"
    }
}