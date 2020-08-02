package com.nwar.domain.useCase

import com.nwar.domain.entity.FollowTeam
import com.nwar.domain.repository.LoadListRepository
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Scheduler

class LoadTeamListForFollowUseCase(mainThread : Scheduler, val loadListRepository: LoadListRepository) : UseCase<Unit, FollowTeam>(mainThread) {
    override fun requestWithData(data: Unit): Flowable<FollowTeam> {
        return loadListRepository.loadFollowingTeamList()
    }
}