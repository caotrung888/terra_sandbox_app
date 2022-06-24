package vn.teko.sandbox.di.module

import dagger.Module
import dagger.Provides
import vn.teko.android.auth.login.ui.TerraAuthUI
import vn.teko.android.terra.auth.TerraAuth
import vn.teko.android.terra.auth.TerraAuthInterface
import vn.teko.apollo.ApolloTheme
import vn.teko.apollo.terra.TerraApollo
import vn.teko.hestia.android.terra.TerraHestia
import vn.teko.hestia.core.HestiaInterface
import vn.teko.terra.core.android.terra.TerraApp
import javax.inject.Singleton


/**
 * Created by TrungCS on 27/09/2021.
 * Email: trung.cs@teko.vn
 * Company: Teko
 */

@Module
object AppModule {

    @Singleton
    @Provides
    internal fun provideAuthUI(terraApp: TerraApp): TerraAuthUI {
        return TerraAuthUI.getInstance(terraApp = terraApp).setCancellable(true)
    }

    @Singleton
    @Provides
    internal fun provideAuthManager(terraApp: TerraApp): TerraAuthInterface {
        return TerraAuth.getInstance(terraApp = terraApp)
    }

    @Singleton
    @Provides
    internal fun provideApolloTheme(terraApp: TerraApp): ApolloTheme {
        return TerraApollo.getInstance(terraApp = terraApp)
    }

    @Singleton
    @Provides
    internal fun provideHestia(terraApp: TerraApp): HestiaInterface {
        return TerraHestia.getInstance(terraApp = terraApp)
    }
}