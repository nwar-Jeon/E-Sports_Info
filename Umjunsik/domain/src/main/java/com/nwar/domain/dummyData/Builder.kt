package com.nwar.domain.dummyData

import com.nwar.domain.entity.*
import java.util.*

private val t1LogoURL = "https://pbs.twimg.com/profile_images/1259666901787045889/Z2C_ETaS_400x400.jpg"

//fun getGameScheduleList() = arrayListOf<GameSchedule>().apply { (0..10).forEach { this.add(getGameSchedule(it)) } }

//fun getGameSchedule(position : Int = 0) = GameSchedule(position, getTeam(position*2), getTeam(position*2+1), 0, 0, Date().time, "장소", 1000, false)

//fun getTeam(id : Int = 0) = Team(id, "SKT T1", t1LogoURL)

fun getLiveChattingList() = arrayListOf<GameLiveChatting>().apply { (0..20).forEach { this.add(getLiveChatting()) } }

fun getLiveChatting() = GameLiveChatting(0, "닉네임", "내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용")

//fun getNewsFeedList() = arrayListOf<NewsFeed>().apply{(0..10).forEach { this.add(getNewsFeed(it)) }}

//fun getNewsFeed(id : Int = 0) = NewsFeed(id, getTeam(), "내용내용내용내용내용내용내용내용내용내용", t1LogoURL, 400000)

//fun getFollowTeam(followed : Boolean) = FollowTeam(0, getTeam(), followed)

//fun getFollowTeamList() = arrayListOf<FollowTeam>().apply { (0..10).forEach { this.add(getFollowTeam(it%2==0)) } }

//fun getHighLight(id : Int = 0, title : String = "") = HighLight(id = id, videoLength = "9:30", videoTitle = "${title}title", gameDate = "2020년 07월 17일", place = "대마고", likeCount = 40000, isLiked = false, videoURL = "VphUYXv-yMQ", thumbNail = t1LogoURL)

//fun getHighLightList(title : String = "") = arrayListOf<HighLight>().apply { (0..10).forEach { this.add(getHighLight(it, title)) } }