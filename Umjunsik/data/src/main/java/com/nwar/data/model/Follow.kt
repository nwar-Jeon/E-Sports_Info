package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class Follow(
    @SerializedName("following")
    val teamName : String = "",
    @SerializedName("team_id")
    val teamId : Int = 0,
    @SerializedName("teamImage")
    val imageURL : String = "",
    @SerializedName("isFollowing")
    val isFollowing : Boolean = false
) {
}