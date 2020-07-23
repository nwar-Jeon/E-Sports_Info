package com.nwar.api.model

import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("matchId")
    val matchId : Int,
    @SerializedName("redTeamId")
    val redTeamId : Int,
    @SerializedName("redTeamName")
    val redTeamName : String,
    @SerializedName("redTeamLogoURL")
    val redTeamLogo : String,
    @SerializedName("blueTeamId")
    val blueTeamId : Int,
    @SerializedName("blueTeamName")
    val blueTeamName : String,
    @SerializedName("blueTeamLogoURL")
    val blueTeamLogo : String,
    @SerializedName("datetime")
    val dateTime : String
) {
}