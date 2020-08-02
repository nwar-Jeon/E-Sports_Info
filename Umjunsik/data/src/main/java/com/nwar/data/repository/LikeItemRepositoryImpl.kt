package com.nwar.data.repository

import com.nwar.data.builder.API
import com.nwar.data.cache.UserCache
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.HighLight
import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.repository.LikeItemRepository
import io.reactivex.rxjava3.core.Flowable

class LikeItemRepositoryImpl(val api : API) : LikeItemRepository {
    override fun likeHighLightByHighLight(data: HighLight): Flowable<HighLight> {
        return UserCache.getToken().flatMap {
            api.requestLikeHighLight(it, data.id)
                .toBodyOrThrow().map { data.copy(likeCount = it.likeCount).apply { toggleLike() } }
        }
    }

    override fun likeMatchByGameSchedule(data: GameSchedule): Flowable<GameSchedule> {
        return UserCache.getToken().flatMap { api.requestLikeMatch(it, data.id)
            .toBodyOrThrow().map { data.copy(like = it.likeCount).apply { likeToggle() } }
        }
    }

    override fun likeNewsFeedByNewsFeed(data: NewsFeed): Flowable<NewsFeed> {
        TODO("Not yet implemented")
    }
}