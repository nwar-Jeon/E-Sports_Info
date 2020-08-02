package com.nwar.data.model

import com.google.gson.annotations.SerializedName

class FollowList(
    @SerializedName("following")
    val followingList : List<Follow>
) {
}