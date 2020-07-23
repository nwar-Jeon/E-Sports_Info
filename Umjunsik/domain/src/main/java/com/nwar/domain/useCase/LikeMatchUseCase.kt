package com.nwar.domain.useCase

import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LikeMatchUseCase(mainScheduler : Scheduler) : UseCase<Pair<GameSchedule, Boolean>, GameSchedule>(mainScheduler) {
    val Pair<GameSchedule,Boolean>.schedule get() = this.first
    val Pair<GameSchedule,Boolean>.isAlreadyLike get() = this.second
    override fun requestWithData(data: Pair<GameSchedule, Boolean>): Flowable<RequestResult<GameSchedule>> {
        //TODO("Not yet implemented")
        val observable = if(data.isAlreadyLike) Observable.just(data.schedule.apply { like-- }) else Observable.just(data.schedule.apply { like++ })
        return observable
            .toFlowable(BackpressureStrategy.DROP)
            .map { RequestResult.success(it) }
            .exceptionRequestResult()
    }
}