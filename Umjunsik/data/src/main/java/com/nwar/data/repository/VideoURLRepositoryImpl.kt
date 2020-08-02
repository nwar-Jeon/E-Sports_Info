package com.nwar.data.repository

import com.nwar.data.builder.API
import com.nwar.data.cache.VideoURLCache
import com.nwar.domain.repository.VideoURLRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

class VideoURLRepositoryImpl(val api : API) : VideoURLRepository {

    override fun clearCache(): Flowable<Unit> {
        return VideoURLCache.clear()
    }

    override fun saveVideoURLToCache(url: String): Flowable<Unit> {
        return VideoURLCache.saveVideoURL(url)
    }

    override fun requireVideoURL(): Flowable<String> {
        return VideoURLCache.getVideoURL()
    }
}