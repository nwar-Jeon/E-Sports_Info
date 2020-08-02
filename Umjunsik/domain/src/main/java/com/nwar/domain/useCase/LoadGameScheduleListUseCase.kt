package com.nwar.domain.useCase

import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.LoadListRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadGameScheduleListUseCase(mainScheduler : Scheduler, val loadListRepository: LoadListRepository) : UseCase<Unit, GameSchedule>(mainScheduler) {
    override fun requestWithData(data: Unit): Flowable<GameSchedule> {
        //TODO("Not yet implemented")
        return loadListRepository.loadGameScheduleList()
    }
}