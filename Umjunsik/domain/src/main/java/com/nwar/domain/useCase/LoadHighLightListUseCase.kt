package com.nwar.domain.useCase

import com.nwar.domain.entity.HighLight
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.LoadListRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadHighLightListUseCase(mainScheduler: Scheduler, val loadListRepository: LoadListRepository) : UseCase<String, HighLight>(mainScheduler) {
    override fun requestWithData(data: String): Flowable<HighLight> {
        return loadListRepository.loadHighLightList(data)
    }
}