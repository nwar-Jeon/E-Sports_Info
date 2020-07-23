package com.nwar.umjunsik.util

import com.nwar.domain.entity.GameSchedule

fun getBlueTeamVotePercentageFromSchedule(schedule: GameSchedule) = "${schedule.getBlueTeamPercentage()}%"

fun getRedTeamVotePercentageFromSchedule(schedule: GameSchedule) = "${schedule.getRedTeamPercentage()}%"

fun getBlueTeamVotePercentageFromScheduleAsInt(schedule: GameSchedule) = schedule.getBlueTeamPercentage().toInt()

fun likeCountToString(count : Int) = "${count}명이 기대 중!"

fun getDateFormat(schedule : GameSchedule) = schedule.timeFormat()

fun getVoteBlueTeamString(schedule: GameSchedule) = "${schedule.blueTeam.name}에 투표하기"

fun getVoteRedTeamString(schedule: GameSchedule) = "${schedule.redTeam.name}에 투표하기"