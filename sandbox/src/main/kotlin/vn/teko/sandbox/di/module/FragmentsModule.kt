package vn.teko.sandbox.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.teko.sandbox.ui.home.HomeFragment

@Module
abstract class FragmentsModule {
    @ContributesAndroidInjector
    internal abstract fun provideHomeFragment(): HomeFragment
}