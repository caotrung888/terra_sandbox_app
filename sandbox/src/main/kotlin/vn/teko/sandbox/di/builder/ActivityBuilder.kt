package vn.teko.sandbox.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.teko.sandbox.di.module.FragmentsModule
import vn.teko.sandbox.ui.SandboxActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            FragmentsModule::class
        ]
    )
    internal abstract fun bindSandboxActivity(): SandboxActivity

}
