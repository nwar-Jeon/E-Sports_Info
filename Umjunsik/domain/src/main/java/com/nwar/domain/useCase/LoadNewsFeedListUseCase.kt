package com.nwar.domain.useCase

import com.nwar.domain.dummyData.getNewsFeedList
import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadNewsFeedListUseCase(val mainScheduler: Scheduler) : UseCase<Unit, NewsFeed>(mainScheduler) {
    override fun requestWithData(data: Unit): Flowable<RequestResult<NewsFeed>> {
        return Observable.just(getNewsFeedList())
            .toFlowable(BackpressureStrategy.DROP)
            .flatMapIterable { it }
            .flatMap { Flowable.just(RequestResult.success(it)) }
            .exceptionRequestResult()
    }
}