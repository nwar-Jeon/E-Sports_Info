package com.nwar.data.model

import com.google.gson.annotations.SerializedName

class CheckDuplicatedModel(
    @SerializedName("duplicated")
    val duplicated : Boolean
) {
}