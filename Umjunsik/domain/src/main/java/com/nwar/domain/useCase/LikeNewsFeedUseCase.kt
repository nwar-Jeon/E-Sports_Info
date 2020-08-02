package com.nwar.domain.useCase

import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.LikeItemRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LikeNewsFeedUseCase(mainScheduler: Scheduler, val likeItemRepository: LikeItemRepository) : UseCase<Pair<NewsFeed, Boolean>, NewsFeed>(mainScheduler) {

    val Pair<NewsFeed, Boolean>.newsFeed get() = this.first

    val Pair<NewsFeed, Boolean>.isAlreadyLike get() = this.second

    override fun requestWithData(data: Pair<NewsFeed, Boolean>): Flowable<NewsFeed> {
        //TODO("Not yet implemented")
        return likeItemRepository.likeNewsFeedByNewsFeed(data.newsFeed)
    }
}