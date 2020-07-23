package com.nwar.domain.entity

data class FollowTeam(
    val id : Int,
    val team : Team,
    var isFollowed : Boolean = false
) {
    fun followToggle() {isFollowed = !isFollowed}

    fun followToggleAndCopy() = copy(isFollowed = !isFollowed)
}