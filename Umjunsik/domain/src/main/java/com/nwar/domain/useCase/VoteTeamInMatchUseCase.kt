package com.nwar.domain.useCase

import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.Team
import com.nwar.domain.extend.extendFunction.exceptionRequestResult
import com.nwar.domain.repository.VoteRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler

class VoteTeamInMatchUseCase(mainScheduler : Scheduler, val voteRepository: VoteRepository) : UseCase<Pair<GameSchedule, Team>, GameSchedule>(mainScheduler) {

    private val Pair<GameSchedule, Team>.schedule get() = this.first
    private val Pair<GameSchedule, Team>.team get() = this.second

    override fun requestWithData(data: Pair<GameSchedule, Team>): Flowable<GameSchedule> {
        //TODO("Not yet implemented")
        return voteRepository.voteMatchByTeam(data.schedule, data.team)
    }
}