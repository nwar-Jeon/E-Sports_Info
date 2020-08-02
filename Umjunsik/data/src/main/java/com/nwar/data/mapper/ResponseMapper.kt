package com.nwar.data.mapper

import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response
import java.lang.RuntimeException

fun <T> Flowable<Response<T>>.toBodyOrThrow(messageMap: Map<Int, String> = mapOf()) : Flowable<T>
    = this.map { it.toBodyOrThrow(messageMap) }

fun <T> Response<T>.toBodyOrThrow(messageMap : Map<Int,String> = mapOf()) : T {
    when(this.code()/100) {
        2 -> return this.body()!!
        else -> throw RuntimeException(getErrorMessage(messageMap, this.code()))
    }
}

private fun getErrorMessage(messageMap: Map<Int, String>, code : Int) : String
        = code.toString() + (messageMap[code] ?: "Error")