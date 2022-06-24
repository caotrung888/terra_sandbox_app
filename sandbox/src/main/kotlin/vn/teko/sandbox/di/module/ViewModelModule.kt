package vn.teko.sandbox.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import vn.teko.android.core.ui.di.viewmodel.ViewModelKey
import vn.teko.sandbox.ui.SandboxViewModel
import vn.teko.sandbox.ui.home.HomeViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SandboxViewModel::class)
    internal abstract fun bindSandboxViewModel(viewModel: SandboxViewModel): ViewModel
}