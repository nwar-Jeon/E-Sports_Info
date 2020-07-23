package com.nwar.domain.repository

import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

interface VideoURLRepository {
    fun requireVideoURL() : Flowable<RequestResult<String>>
}