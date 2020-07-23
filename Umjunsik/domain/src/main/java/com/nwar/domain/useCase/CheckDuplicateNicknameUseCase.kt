package com.nwar.domain.useCase

import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class CheckDuplicateNicknameUseCase(mainThread : Scheduler) : UseCase<String, Boolean>(mainThread) {
    override fun requestWithData(data: String): Flowable<RequestResult<Boolean>> {
        //TODO("서버연동")
        return Observable.just(data!="abcd")
            .toFlowable(BackpressureStrategy.DROP)
            .map { RequestResult.success(it) }
            .exceptionRequestResult()
    }
}