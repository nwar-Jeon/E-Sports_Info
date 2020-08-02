package com.nwar.data.model

import com.google.gson.annotations.SerializedName

class HighLightModel(
    @SerializedName("videoId")
    val videoId : Int,
    @SerializedName("videoName")
    val videoName : String,
    @SerializedName("videoImageURL")
    val imageURL : String,
    @SerializedName("videoURL")
    val videoURL : String,
    @SerializedName("datetime")
    val dateTime : String,
    @SerializedName("likeCount")
    val likeCount : Int
) {
}