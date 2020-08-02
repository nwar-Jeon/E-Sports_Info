package com.nwar.domain.repository

import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.HighLight
import com.nwar.domain.entity.NewsFeed
import io.reactivex.rxjava3.core.Flowable

interface LikeItemRepository {
    fun likeHighLightByHighLight(data : HighLight) : Flowable<HighLight>

    fun likeMatchByGameSchedule(data : GameSchedule) : Flowable<GameSchedule>

    fun likeNewsFeedByNewsFeed(data : NewsFeed) : Flowable<NewsFeed>
}