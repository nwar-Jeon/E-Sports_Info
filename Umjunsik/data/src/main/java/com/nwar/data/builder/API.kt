package com.nwar.data.builder

import com.google.gson.annotations.SerializedName
import com.nwar.data.model.*
import io.reactivex.rxjava3.core.Flowable
import retrofit2.Response
import retrofit2.http.*

interface API {

    @GET("/users/duplicate")
    fun requestIsIdDuplicate(@Query("id")replaceId : String) : Flowable<Response<CheckDuplicatedModel>>

    @GET("/users/following")
    fun requestFollowingTeamList()

    @GET("/match/schedule")
    fun requestMatchList() : Flowable<Response<ScheduleList>>

    @GET("/match/vote/{match_id}")
    fun requestVoteRatio(@Path("match_id")matchId : Int) : Flowable<Response<MatchVote>>

    @GET("/match/like/{match_id}")
    fun requestLikeCountByMatchId(@Header("Authrization")token : String, @Path("match_id")matchId : Int) : Flowable<Response<LikeCountModel>>

    @GET("/users/highlights")
    fun requestHighLights(@Query("query") searchString : String) : Flowable<Response<HighLightList>>

    @GET("/team")
    fun getTeamList() : Flowable<Response<FollowList>>

    @POST("/match/vote/{match_id}")
    fun requestVote(@Header("Authrization")token : String, @Path("match_id")matchId : Int, @Body teamId : TeamId) : Flowable<Response<Schedule>>

    @POST("/match/like/{match_id}")
    fun requestLikeMatch(@Header("Authrization")token : String, @Path("match_id")matchId : Int) : Flowable<Response<LikeCountModel>>

    @POST("/video/like/{videoId}")
    fun requestLikeHighLight(@Header("Authrization")token : String, @Path("videoId") videoId : Int) : Flowable<Response<LikeCountModel>>

    @POST("/auth/login")
    fun requestLogin(@Body account : Account) : Flowable<Response<String>>

    @POST("/auth/signup")
    fun requestSignUp(@Body account: Account) : Flowable<Response<Unit>>

    @POST("/team/follow")
    fun requestFollowTeam(@Body team : Follow) : Flowable<Response<Unit>>

    @PATCH("/users/nickname")
    fun requestChangeNickname(@Body inputNickNameInfo : ChangeNickName) : Flowable<Response<String>>
}