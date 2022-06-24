@file:Suppress("SpellCheckingInspection")

package vn.teko.sandbox

import vn.teko.android.core.ui.BaseApplication
import vn.teko.android.terra.auth.TerraAuth
import vn.teko.sandbox.di.component.DaggerAppComponent
import vn.teko.terra.core.android.terra.TerraApp


/**
 * Created by TrungCS on 23/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */
class SandboxApp : BaseApplication() {
    override fun getVersion() = BuildConfig.VERSION_NAME

    override fun performDependencyInjection() {

        val terraApp = TerraApp.initializeApp(application = this)

        TerraAuth.getInstance(terraApp).initAuthFlow()

        DaggerAppComponent.builder()
            .application(this)
            .terraApp(terraApp)
            .build()
            .inject(this)
    }
}

