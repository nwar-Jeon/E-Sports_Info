package com.nwar.domain.repository

import com.nwar.domain.entity.User
import io.reactivex.rxjava3.core.Flowable

interface AccountRepository {
    fun signInByUser(data : User) : Flowable<User>

    fun signUpByUser(data : User) : Flowable<User>
}