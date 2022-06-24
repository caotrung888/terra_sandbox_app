package vn.teko.sandbox.nativeminiapptest

import android.app.Application
import android.content.Intent
import vn.teko.sandbox.nativeminiapptest.ui.MiniAppShoppingActivity


/**
 * Created by TrungCS on 15/10/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
object DemoMiniAppSdk {
    private const val ID_TOKEN_KEY = "idToken"
    private const val NAME_KEY = "name"
    private const val ADDRESS_KEY = "address"

    fun createInstance(
        application: Application,
        config: Config
    ): Intent {
        return Intent(application, MiniAppShoppingActivity::class.java).apply {
            config.also {
                it.idToken?.also {
                    putExtra(ID_TOKEN_KEY, it)
                }

                it.name?.also {
                    putExtra(NAME_KEY, it)
                }

                it.address?.also {
                    putExtra(ADDRESS_KEY, it)
                }
            }
        }
    }

    data class Config(
        val idToken: String?,
        val name: String?,
        val address: String?,
    )
}