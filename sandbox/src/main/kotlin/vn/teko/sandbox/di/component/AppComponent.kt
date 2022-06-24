package vn.teko.sandbox.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import vn.teko.sandbox.SandboxApp
import vn.teko.sandbox.di.builder.ActivityBuilder
import vn.teko.sandbox.di.module.AppModule
import vn.teko.sandbox.di.module.ViewModelModule
import vn.teko.terra.core.android.terra.TerraApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        ActivityBuilder::class,
        AppModule::class,
    ]
)
interface AppComponent {

    fun inject(core: SandboxApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun terraApp(terraApp: TerraApp): Builder

        fun build(): AppComponent
    }

}
