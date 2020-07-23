package com.nwar.domain.entity

data class NewsFeed(
    val id : Int,
    val team : Team,
    val content : String,
    val imageContent : String,
    var likeCount : Int,
    var isLiked : Boolean = false
) {
    fun toggleLikedAndCopy() = copy(isLiked = !isLiked)

    fun toggleLiked() { isLiked = !isLiked }

    override fun equals(other: Any?): Boolean = if(other !is NewsFeed) false else other.id==id

    override fun hashCode(): Int = id.hashCode()
}