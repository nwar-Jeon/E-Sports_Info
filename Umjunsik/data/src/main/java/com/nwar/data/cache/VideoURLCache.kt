package com.nwar.data.cache

import io.reactivex.rxjava3.core.Flowable
import java.lang.RuntimeException

object VideoURLCache {
    var videoURL: String = ""

    fun getVideoURL() = Flowable.just(videoURL)

    fun saveVideoURL(url : String) : Flowable<Unit> {
        videoURL = url
        return Flowable.just(Unit)
    }

    fun clear() : Flowable<Unit> {
        videoURL = ""
        return Flowable.just(Unit)
    }
}