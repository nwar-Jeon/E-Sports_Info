package com.nwar.domain.useCase

import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.extend.extendFunction.toRequestResult
import com.nwar.domain.repository.CheckDuplicateRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class CheckDuplicateNicknameUseCase(mainThread : Scheduler, val checkDuplicateRepository: CheckDuplicateRepository) : UseCase<String, Boolean>(mainThread) {
    override fun requestWithData(data: String): Flowable<Boolean> {
        return requireDuplicateNickname(data)
    }

    fun requireDuplicateNickname(nickName : String): Flowable<Boolean> {
        return checkDuplicateRepository.checkDuplicateByNickname(nickName)
    }
}