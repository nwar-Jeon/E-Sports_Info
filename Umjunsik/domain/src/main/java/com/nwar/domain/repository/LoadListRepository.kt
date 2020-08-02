package com.nwar.domain.repository

import com.nwar.domain.entity.FollowTeam
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.HighLight
import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

interface LoadListRepository {
    fun loadGameScheduleList() : Flowable<GameSchedule>

    fun loadHighLightList(searchText : String) : Flowable<HighLight>

    fun loadNewsFeedList() : Flowable<NewsFeed>

    fun loadFollowingTeamList() : Flowable<FollowTeam>
}