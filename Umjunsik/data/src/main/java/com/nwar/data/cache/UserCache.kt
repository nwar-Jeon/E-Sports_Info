package com.nwar.data.cache

import com.nwar.domain.entity.User
import io.reactivex.rxjava3.core.Flowable
import java.lang.RuntimeException

object UserCache {
    var user : User? = null

    fun getToken() =
        if(user?.authorization?.isBlank() != false) Flowable.error(RuntimeException("토큰 정보가 없음."))
        else Flowable.just(user!!.authorization)

    fun saveUser(data : User) : Flowable<Unit> {
        user = data
        return Flowable.just(Unit)
    }
}