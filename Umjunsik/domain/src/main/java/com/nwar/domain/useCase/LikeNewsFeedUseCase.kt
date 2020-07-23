package com.nwar.domain.useCase

import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LikeNewsFeedUseCase(mainScheduler: Scheduler) : UseCase<Pair<NewsFeed, Boolean>, NewsFeed>(mainScheduler) {

    val Pair<NewsFeed, Boolean>.newsFeed get() = this.first

    val Pair<NewsFeed, Boolean>.isAlreadyLike get() = this.second

    override fun requestWithData(data: Pair<NewsFeed, Boolean>): Flowable<RequestResult<NewsFeed>> {
        //TODO("Not yet implemented")
        val newsFeed = data.newsFeed.copy(id = data.newsFeed.id, likeCount = data.newsFeed.likeCount)
        return Observable.just(if(data.isAlreadyLike) newsFeed.apply { likeCount-- } else newsFeed.apply { likeCount++ })
            .toFlowable(BackpressureStrategy.DROP)
            .map { RequestResult.success(it) }
            .exceptionRequestResult()
    }
}