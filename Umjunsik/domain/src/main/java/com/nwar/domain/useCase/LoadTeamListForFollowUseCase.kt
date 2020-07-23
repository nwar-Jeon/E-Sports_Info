package com.nwar.domain.useCase

import com.nwar.domain.dummyData.getFollowTeamList
import com.nwar.domain.entity.FollowTeam
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadTeamListForFollowUseCase(mainThread : Scheduler) : UseCase<Unit, FollowTeam>(mainThread) {
    override fun requestWithData(data: Unit): Flowable<RequestResult<FollowTeam>> {
        //TODO("Not yet implemented")
        return Observable.just(getFollowTeamList())
            .toFlowable(BackpressureStrategy.DROP)
            .flatMapIterable { it }
            .flatMap { Flowable.just(RequestResult.success(it)) }
            .exceptionRequestResult()
    }
}