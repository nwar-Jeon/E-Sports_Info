package com.nwar.umjunsik.di.application

import com.nwar.umjunsik.di.component.DaggerBaseComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication() : DaggerApplication() {
    var injector : AndroidInjector<DaggerApplication>? = null
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>?
        = injector ?: DaggerBaseComponent.factory().create(this)
}