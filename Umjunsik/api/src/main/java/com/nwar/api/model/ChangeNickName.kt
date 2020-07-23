package com.nwar.api.model

import com.google.gson.annotations.SerializedName

data class ChangeNickName(
    @SerializedName("currentNickname")
    val currentNickname : String,
    @SerializedName("newNickname")
    val newNickname : String
) {
}