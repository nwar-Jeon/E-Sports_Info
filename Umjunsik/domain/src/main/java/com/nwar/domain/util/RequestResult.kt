package com.nwar.domain.util

class RequestResult<T> private constructor(private val value : T? = null, private val exception: Throwable? = null) {
    companion object {
        fun <T>success(data : T) = RequestResult(value = data)
        fun <T>failure(exception : Throwable) = RequestResult<T>(exception = exception)
    }
    fun isSuccess() = value != null && exception == null

    fun isFailure() = value == null && exception != null

    fun getResult() = if(isSuccess()) this else RequestResult(value = exception)

    fun getValue() = value

    fun getException() = exception

    fun <R>map(mapping : (T) -> R) = if(isSuccess()) success(mapping(value!!)) else failure(exception = exception!!)
}