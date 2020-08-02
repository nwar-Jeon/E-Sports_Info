package com.nwar.data.repository

import com.nwar.data.builder.API
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.domain.repository.CheckDuplicateRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

class CheckDuplicateRepositoryImpl(val api : API) : CheckDuplicateRepository {
    override fun checkDuplicateById(id: String): Flowable<Boolean> {
        return api.requestIsIdDuplicate(id)
            .map { it.toBodyOrThrow() }
            .map { it.duplicated }
    }

    override fun checkDuplicateByNickname(nickName: String): Flowable<Boolean> {
        TODO("서버 api가 없음.")
    }
}