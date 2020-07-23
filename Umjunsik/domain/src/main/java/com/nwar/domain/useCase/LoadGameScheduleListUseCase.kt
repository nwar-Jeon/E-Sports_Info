package com.nwar.domain.useCase

import com.nwar.domain.dummyData.getGameScheduleList
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadGameScheduleListUseCase(mainScheduler : Scheduler) : UseCase<Unit, GameSchedule>(mainScheduler) {
    override fun requestWithData(data: Unit): Flowable<RequestResult<GameSchedule>> {
        //TODO("Not yet implemented")
        return Observable.just(getGameScheduleList())
            .toFlowable(BackpressureStrategy.DROP)
            .flatMapIterable{it}
            .flatMap { Flowable.just(RequestResult.success(it)) }
            .exceptionRequestResult()
    }
}