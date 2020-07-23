package com.nwar.domain.useCase

import com.nwar.domain.entity.User
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class SignUpUseCase(mainScheduler: Scheduler) : UseCase<User, User>(mainScheduler) {
    override fun requestWithData(data: User): Flowable<RequestResult<User>> {
        //TODO ("서버연동")
        return Observable.just(data)
            .toFlowable(BackpressureStrategy.DROP)
            .map { RequestResult.success(it) }
            .exceptionRequestResult()
    }
}