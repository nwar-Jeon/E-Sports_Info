package com.nwar.api.builder

import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface API {

    @GET("/users/duplicate")
    fun requestIsIdDuplicate()

    @GET("/users/following")
    fun requestFollowingTeamList()

    @GET("/match/schedule")
    fun requestMatchList()

    @GET("/match/{match_id}/vote")
    fun requestVoteRatio(@Path("match_id")matchId : Int)

    @GET("/match/{match_id}/like")
    fun requestLikeCountByMatchId(@Path("match_id")matchId : Int)

    @GET("/users/highlights")
    fun requestHighLights()

    @POST("/match/{match_id}/vote")
    fun requestVote(@Path("match_id")matchId : Int)

    @POST("/match/{match_id}/like")
    fun requestLikeMatch(@Path("match_id")matchId : Int)

    @POST("/auth/login")
    fun requestLogdin()

    @POST("/auth/signup")
    fun requestSignUp()

    @POST("/team/follow")
    fun requestFollowTeam()

    @PATCH("/users/nickname")
    fun requestChangeNickname()
}