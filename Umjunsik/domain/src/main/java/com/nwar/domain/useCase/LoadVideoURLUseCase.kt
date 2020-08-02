package com.nwar.domain.useCase

import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.VideoURLRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class LoadVideoURLUseCase(mainScheduler: Scheduler, val videoURLRepository: VideoURLRepository) : UseCase<Unit, String>(mainScheduler) {
    override fun requestWithData(data: Unit): Flowable<String> {
        return videoURLRepository.requireVideoURL()
    }
}