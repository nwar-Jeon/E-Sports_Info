package com.nwar.domain.repository

import com.nwar.domain.entity.FollowTeam
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.HighLight
import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

interface LoadListRepository {
    fun loadGameScheduleList() : Flowable<RequestResult<GameSchedule>>

    fun loadHighLightList() : Flowable<RequestResult<HighLight>>

    fun loadNewsFeedList() : Flowable<RequestResult<NewsFeed>>

    fun loadFollowingTeamList() : Flowable<RequestResult<FollowTeam>>
}