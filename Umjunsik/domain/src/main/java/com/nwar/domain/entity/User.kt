package com.nwar.domain.entity

data class User(
    val id : Int = 0,
    val authorization : String = "",
    val userId : String = "",
    val password : String = "",
    val nickName : String = ""
) {
}