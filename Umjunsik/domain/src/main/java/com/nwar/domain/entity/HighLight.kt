package com.nwar.domain.entity

data class HighLight(
    val id : Int,
    val thumbNail : String,
    val videoLength : String,
    val videoTitle : String,
    val gameDate : String,
    val place : String,
    var likeCount : Int,
    var isLiked : Boolean,
    val videoURL : String
) {
    fun toggleLike() { isLiked = !isLiked}

    override fun equals(other: Any?): Boolean = if(other !is HighLight) false else id==other.id

    override fun hashCode(): Int = id.hashCode()
}