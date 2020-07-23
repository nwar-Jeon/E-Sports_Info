package com.nwar.domain.useCase

import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subscribers.DisposableSubscriber


abstract class UseCase<T, R>(val mainThread : Scheduler) {

    var disposable = CompositeDisposable()

    abstract fun requestWithData(data : T) : Flowable<RequestResult<R>>

    fun excute(data : T, observer: DisposableSubscriber<RequestResult<R>>) {
        val flowable = requestWithData(data)
            .subscribeOn(Schedulers.io())
            .observeOn(mainThread)
            .subscribeWith(observer)
        disposable.add(flowable)
    }

    fun dispose() = disposable.dispose()
}