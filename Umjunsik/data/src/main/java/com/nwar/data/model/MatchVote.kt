package com.nwar.data.model

import com.google.gson.annotations.SerializedName

class MatchVote(
    @SerializedName("redTeamVoteCount")
    val redVoteCount : Int,
    @SerializedName("blueTeamVoteCount")
    val blueVoteCount : Int
) {
}