package com.nwar.domain.extend.extendFunction

import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable
import java.lang.Exception

fun <T> Flowable<T>.exceptionRequestResult() : Flowable<T> {
    this.doOnError { RequestResult.failure<T>(it) }
    return this
}

fun <T>Flowable<T>.toRequestResult() : Flowable<RequestResult<T>> {
    return this.map { RequestResult.success(it) }
        .doOnError { RequestResult.failure<T>(it) }
}