package com.nwar.umjunsik.di.module

import android.content.Context
import com.nwar.data.builder.API
import com.nwar.data.builder.createRetrofit
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

    @Singleton
    @Provides
    fun mainSchedule() : Scheduler = AndroidSchedulers.mainThread()

    @Singleton
    @Provides
    fun api() : API = createRetrofit(API::class.java)
}