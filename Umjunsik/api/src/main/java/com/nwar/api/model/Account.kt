package com.nwar.api.model

import com.google.gson.annotations.SerializedName

data class Account (
    @SerializedName("id")
    val id : String,
    @SerializedName("password")
    val password : String,
    @SerializedName("accessToken")
    val accessToken : String,
    @SerializedName("nickname")
    val nickname : String
)