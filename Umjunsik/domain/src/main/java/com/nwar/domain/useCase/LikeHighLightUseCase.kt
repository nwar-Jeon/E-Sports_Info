package com.nwar.domain.useCase

import com.nwar.domain.entity.HighLight
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LikeHighLightUseCase(mainScheduler: Scheduler) : UseCase<Pair<HighLight, Boolean>, HighLight>(mainScheduler) {

    val Pair<HighLight,Boolean>.highLight get() = this.first

    val Pair<HighLight, Boolean>.isAlreadyLike get() = this.second

    override fun requestWithData(data: Pair<HighLight, Boolean>): Flowable<RequestResult<HighLight>> {
        //TODO("Not yet implemented")
        val countCalc = if(data.isAlreadyLike) -1 else 1
        return Observable.just(data.highLight.let { it.copy(id = it.id, likeCount = it.likeCount + countCalc) }.apply { toggleLike() })
            .toFlowable(BackpressureStrategy.DROP)
            .map { RequestResult.success(it) }
            .exceptionRequestResult()
    }
}