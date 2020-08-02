package com.nwar.data.repository

import com.nwar.data.builder.API
import com.nwar.data.cache.UserCache
import com.nwar.data.mapper.toBodyOrThrow
import com.nwar.data.model.TeamId
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.entity.Team
import com.nwar.domain.repository.VoteRepository
import com.nwar.domain.util.RequestResult
import io.reactivex.rxjava3.core.Flowable

class VoteRepositoryImpl(val api : API) : VoteRepository {
    override fun voteMatchByTeam(schedule: GameSchedule, team: Team): Flowable<GameSchedule> {
        return UserCache.getToken().flatMap {
            api.requestVote(it, schedule.id, TeamId(team.id)).toBodyOrThrow()
                .map { schedule.copy(voteBlueTeam = it.blueTeamVoteCount, voteRedTeam = it.redTeamVoteCount) }
        }
    }
}