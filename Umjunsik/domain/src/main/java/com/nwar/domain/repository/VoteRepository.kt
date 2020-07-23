package com.nwar.domain.repository

import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.Team
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

interface VoteRepository {
    fun voteMatchByTeam(schedule : GameSchedule, team : Team) : Flowable<RequestResult<GameSchedule>>
}