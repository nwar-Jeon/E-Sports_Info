package com.nwar.domain.repository

import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

interface CheckDuplicateRepository {
    fun checkDuplicateById(id : String) : Flowable<Boolean>

    fun checkDuplicateByNickname(nickName : String) : Flowable<Boolean>
}