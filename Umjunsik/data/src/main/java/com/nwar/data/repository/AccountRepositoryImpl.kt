package com.nwar.data.repository

import com.nwar.data.builder.API
import com.nwar.data.cache.UserCache
import com.nwar.data.mapper.toAccount
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.domain.entity.User
import com.nwar.domain.repository.AccountRepository
import io.reactivex.rxjava3.core.Flowable

class AccountRepositoryImpl(val api : API) : AccountRepository {
    override fun signInByUser(data: User): Flowable<User> {
        return api.requestLogin(data.toAccount())
            .map { it.toBodyOrThrow() }
            .map { User(data.id,it,data.userId,data.password,data.nickName) }
            .map { it.apply { UserCache.saveUser(it) } }
    }

    override fun signUpByUser(data: User): Flowable<User> {
        return api.requestSignUp(data.toAccount())
            .map { it.toBodyOrThrow() }
            .map { data }
    }
}