package com.nwar.umjunsik.di.module

import android.content.Context
import com.nwar.umjunsik.di.application.BaseApplication
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Singleton

@Module
class AppModule() {
    @Provides
    @Singleton
    fun application(app : BaseApplication) = app

    @Provides
    @Singleton
    fun context(app : BaseApplication) = app as Context

    @Provides
    @Singleton
    fun mainSchedule() : Scheduler = AndroidSchedulers.mainThread()
}