package com.nwar.domain.useCase

import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadVideoURLUseCase(mainScheduler: Scheduler) : UseCase<Unit, String>(mainScheduler) {
    override fun requestWithData(data: Unit): Flowable<RequestResult<String>> {
        //TODO("Not yet implemented")
        return Observable.just("VphUYXv-yMQ")
            .toFlowable(BackpressureStrategy.DROP)
            .flatMap { Flowable.just(RequestResult.success(it)) }
            .exceptionRequestResult()
    }
}