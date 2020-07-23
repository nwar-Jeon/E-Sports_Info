package com.nwar.umjunsik.di.module

import com.nwar.umjunsik.ui.activity.MainActivity
import com.nwar.umjunsik.di.module.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule() {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity() : MainActivity
}