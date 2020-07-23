package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.LikeMatchUseCase
import com.nwar.domain.useCase.LoadGameScheduleListUseCase
import com.nwar.domain.useCase.VoteTeamInMatchUseCase

class GameScheduleViewModelFactory(
    private val loadGameScheduleListUseCase: LoadGameScheduleListUseCase,
    private val voteTeamInMatchUseCase: VoteTeamInMatchUseCase,
    private val likeMatchUseCase: LikeMatchUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        modelClass.getConstructor(
            loadGameScheduleListUseCase::class.java,
            voteTeamInMatchUseCase::class.java,
            likeMatchUseCase::class.java
        ).newInstance(
            loadGameScheduleListUseCase,
            voteTeamInMatchUseCase,
            likeMatchUseCase
        )
}