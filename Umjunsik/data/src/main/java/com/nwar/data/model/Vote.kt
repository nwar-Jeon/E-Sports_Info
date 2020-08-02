package com.nwar.data.model

import com.google.gson.annotations.SerializedName

data class Vote(
    @SerializedName("match_id")
    val matchId : Int,
    @SerializedName("team_id")
    val teamId : Int,
    @SerializedName("RedTeamRatio")
    val redTeamRatio : Double,
    @SerializedName("BlueTeamRatio")
    val blueTeamRatio : Double
) {
}