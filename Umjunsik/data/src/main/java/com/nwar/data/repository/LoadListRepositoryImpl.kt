package com.nwar.data.repository

import com.nwar.data.builder.API
import com.nwar.data.cache.UserCache
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.data.mapper.toFollowTeam
import com.nwar.data.mapper.toGameSchedule
import com.nwar.data.mapper.toHighLight
import com.nwar.data.model.Schedule
import com.nwar.data.model.ScheduleList
import com.nwar.domain.entity.FollowTeam
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.HighLight
import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.repository.LoadListRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.functions.BiFunction

class LoadListRepositoryImpl(val api: API) : LoadListRepository {
    override fun loadFollowingTeamList(): Flowable<FollowTeam> {
        return api.getTeamList().toBodyOrThrow()
            .flatMapIterable { it.followingList }
            .map { it.toFollowTeam() }
    }

    override fun loadGameScheduleList(): Flowable<GameSchedule> {
        return Flowable.zip(UserCache.getToken(), api.requestMatchList().toBodyOrThrow(), BiFunction { token : String, list : ScheduleList -> token to list })
            .flatMapIterable { pair -> arrayListOf<Pair<String, Schedule>>().apply { pair.second.scheduleList.forEach { this.add(pair.first to it) } } }
            .flatMap {
                api.requestLikeCountByMatchId(it.first, it.second.matchId).toBodyOrThrow()
                    .map { likeCount -> it.second.toGameSchedule(likeCount) }
            }
    }

    override fun loadHighLightList(searchText : String): Flowable<HighLight> {
        return api.requestHighLights(searchText).toBodyOrThrow()
            .flatMapIterable { it.videoList }
            .map { it.toHighLight() }
    }

    override fun loadNewsFeedList(): Flowable<NewsFeed> {
        TODO("Not yet implemented")
    }
}