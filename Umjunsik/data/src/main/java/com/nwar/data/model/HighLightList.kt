package com.nwar.data.model

import com.google.gson.annotations.SerializedName

class HighLightList(
    @SerializedName("videos")
    val videoList : List<HighLightModel>
) {
}