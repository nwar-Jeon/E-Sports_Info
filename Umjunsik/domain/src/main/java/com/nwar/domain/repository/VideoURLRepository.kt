package com.nwar.domain.repository

import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

interface VideoURLRepository {

    fun clearCache() : Flowable<Unit>

    fun requireVideoURL() : Flowable<String>

    fun saveVideoURLToCache(url : String) : Flowable<Unit>
}