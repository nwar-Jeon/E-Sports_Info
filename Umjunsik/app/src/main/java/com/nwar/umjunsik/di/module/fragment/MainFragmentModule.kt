package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.umjunsik.ui.fragment.*
import com.nwar.umjunsik.viewModel.viewModel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [MainFragmentInjector::class])
abstract class MainFragmentModule() {
    @ContributesAndroidInjector(modules = [GameScheduleModule::class])
    abstract fun gameScheduleFragment() : GameScheduleFragment

    @ContributesAndroidInjector(modules = [GameLiveModule::class])
    abstract fun gameLiveFragment() : GameLiveFragment

    @ContributesAndroidInjector(modules = [GameHighLightModule::class])
    abstract fun gameHighLightFragment() : GameHighLightFragment

    @ContributesAndroidInjector(modules = [NewsFeedModule::class])
    abstract fun newsFeedFragment() : NewsFeedFragment
}

@Module
class MainFragmentInjector() {
    @Provides
    fun viewModel(fragment : MainFragment) : MainViewModel = ViewModelProviders.of(fragment)[MainViewModel::class.java]
}