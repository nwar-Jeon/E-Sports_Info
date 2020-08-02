package com.nwar.data.builder

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val baseURL: String
    get() = "http://umjunsik.ap-northeast-2.elasticbeanstalk.com/"

val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .baseUrl(baseURL)
    .build()

fun <T>createRetrofit(service : Class<T>) = retrofit.create(service)