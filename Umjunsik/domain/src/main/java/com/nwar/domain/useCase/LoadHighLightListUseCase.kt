package com.nwar.domain.useCase

import com.nwar.domain.dummyData.getHighLightList
import com.nwar.domain.entity.HighLight
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadHighLightListUseCase(mainScheduler: Scheduler) : UseCase<String, HighLight>(mainScheduler) {
    override fun requestWithData(data: String): Flowable<RequestResult<HighLight>> {
        //TODO("Not yet implemented")
        return Observable.just(getHighLightList(data))
            .toFlowable(BackpressureStrategy.DROP)
            .flatMapIterable { it }
            .flatMap { Flowable.just(RequestResult.success(it)) }
            .exceptionRequestResult()
    }
}