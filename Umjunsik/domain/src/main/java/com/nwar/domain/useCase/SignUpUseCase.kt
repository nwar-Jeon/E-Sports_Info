package com.nwar.domain.useCase

import com.nwar.domain.entity.User
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class SignUpUseCase(mainScheduler: Scheduler, val accountRepository: AccountRepository) : UseCase<User, User>(mainScheduler) {
    override fun requestWithData(data: User): Flowable<User> {
        return accountRepository.signUpByUser(data)
    }
}