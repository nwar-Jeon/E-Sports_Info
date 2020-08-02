package com.nwar.data.mapper

import com.nwar.data.model.*
import com.nwar.domain.entity.*

fun Account.toUser() = User(0, this.accessToken, this.id, this.password, this.nickname)

fun Follow.toFollowTeam() = FollowTeam(this.teamId, Team(this.teamId, this.teamName, this.imageURL), this.isFollowing)

fun Schedule.toGameSchedule(likeCountModel: LikeCountModel) = GameSchedule(0,Team(this.blueTeamId,this.blueTeamName,this.blueTeamLogo),Team(this.redTeamId,this.redTeamName,this.redTeamLogo), this.blueTeamVoteCount,this.redTeamVoteCount,this.dateTime,"",likeCountModel.likeCount,false)

fun HighLightModel.toHighLight() = HighLight(this.videoId, this.imageURL, "", this.videoName, this.dateTime, "", this.likeCount, false, this.videoURL)