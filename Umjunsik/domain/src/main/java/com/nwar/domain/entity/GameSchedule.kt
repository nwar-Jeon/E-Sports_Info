package com.nwar.domain.entity

import com.nwar.domain.util.roundDouble
import java.text.SimpleDateFormat
import java.util.*
import com.nwar.domain.extend.extendFunction.*
import java.lang.RuntimeException

data class GameSchedule(
    val id : Int,
    val blueTeam : Team,
    val redTeam : Team,
    var voteBlueTeam : Int,
    var voteRedTeam : Int,
    val time : Long,
    val place : String,
    var like : Int,
    var isLiked : Boolean
) {
    fun totalVoteCount() = voteBlueTeam + voteRedTeam

    fun getBlueTeamPercentage() = ((voteBlueTeam.toDouble()/totalVoteCount().toDouble().returnOneIfZero()) * 100.toDouble()).roundDouble(1)

    fun getRedTeamPercentage() = ((voteRedTeam.toDouble()/totalVoteCount().toDouble().returnOneIfZero()) * 100.toDouble()).roundDouble(1)

    fun timeFormat() = SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분").format(Date(time))

    fun likeToggle() {isLiked = !isLiked}

    fun voteBlueTeam() {voteBlueTeam++}

    fun voteRedTeam() {voteRedTeam++}

    fun likeToggleAndCopy() = copy(isLiked = !isLiked)

    fun voteBlueTeamAndCopy() = copy(voteBlueTeam = voteBlueTeam+1)

    fun voteRedTeamAndCopy() = copy(voteRedTeam = voteRedTeam+1)

    fun voteTeam(team : Team) {
        when(team.id) {
            blueTeam.id -> voteBlueTeam()
            redTeam.id -> voteRedTeam()
            else -> throw RuntimeException("There is no Team Id in match.")
        }
    }

    fun voteTeamWithId(teamId : Int) {
        when(teamId) {
            blueTeam.id -> voteBlueTeam()
            redTeam.id -> voteRedTeam()
            else -> throw RuntimeException("There is no Team Id in match.")
        }
    }

    override fun equals(other: Any?): Boolean = if(other !is GameSchedule) false else id==other.id

    override fun hashCode(): Int = id.hashCode()
}