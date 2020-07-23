package com.nwar.api.model

import com.google.gson.annotations.SerializedName

data class Follow(
    @SerializedName("following")
    val teamName : String,
    @SerializedName("team_id")
    val teamId : Int
) {
}