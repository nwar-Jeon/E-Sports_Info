package com.nwar.umjunsik.di.component

import com.nwar.umjunsik.di.application.BaseApplication
import com.nwar.umjunsik.di.module.ActivityModule
import com.nwar.umjunsik.di.module.AppModule
import com.nwar.umjunsik.di.module.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityModule::class,
    AppModule::class
])
interface BaseComponent : AndroidInjector<BaseApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application : BaseApplication) : BaseComponent
    }
}