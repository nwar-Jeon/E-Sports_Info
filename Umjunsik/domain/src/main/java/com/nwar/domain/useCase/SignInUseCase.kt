package com.nwar.domain.useCase

import com.nwar.domain.entity.User
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class SignInUseCase(mainScheduler: Scheduler) : UseCase<User, User>(mainScheduler) {
    override fun requestWithData(data: User): Flowable<RequestResult<User>> {
        //TODO("Not yet implemented")
        val result = if(data.userId=="userId") Observable.just(User(authorization = "Bearer ...")) else Observable.error(Exception("404 Error"))
        return result.toFlowable(BackpressureStrategy.DROP)
            .map { RequestResult.success(it) }
            .exceptionRequestResult()
    }
}