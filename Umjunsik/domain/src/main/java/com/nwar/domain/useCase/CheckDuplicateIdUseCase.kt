package com.nwar.domain.useCase

import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.extend.extendFunction.toRequestResult
import com.nwar.domain.repository.CheckDuplicateRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class CheckDuplicateIdUseCase(mainScheduler : Scheduler, val checkDuplicateRepository: CheckDuplicateRepository) : UseCase<String, Boolean>(mainScheduler) {
    override fun requestWithData(data: String): Flowable<Boolean> {
        return requireCheckDuplicateId(data)
    }

    fun requireCheckDuplicateId(id : String) : Flowable<Boolean> {
        return checkDuplicateRepository.checkDuplicateById(id)
    }
}