package com.nwar.domain.useCase

import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.repository.LoadListRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler

class LoadNewsFeedListUseCase(val mainScheduler: Scheduler, val loadListRepository: LoadListRepository) : UseCase<Unit, NewsFeed>(mainScheduler) {
    override fun requestWithData(data: Unit): Flowable<NewsFeed> {
        return loadListRepository.loadNewsFeedList()
    }
}