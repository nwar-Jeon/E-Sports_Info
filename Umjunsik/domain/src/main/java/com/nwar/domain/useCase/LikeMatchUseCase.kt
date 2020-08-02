package com.nwar.domain.useCase

import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.LikeItemRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LikeMatchUseCase(mainScheduler : Scheduler, val likeItemRepository: LikeItemRepository) : UseCase<Pair<GameSchedule, Boolean>, GameSchedule>(mainScheduler) {
    val Pair<GameSchedule,Boolean>.schedule get() = this.first
    val Pair<GameSchedule,Boolean>.isAlreadyLike get() = this.second
    override fun requestWithData(data: Pair<GameSchedule, Boolean>): Flowable<GameSchedule> {
        return likeItemRepository.likeMatchByGameSchedule(data.schedule)
    }
}