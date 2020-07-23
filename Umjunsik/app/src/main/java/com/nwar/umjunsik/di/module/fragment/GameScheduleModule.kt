package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.LikeMatchUseCase
import com.nwar.domain.useCase.LoadGameScheduleListUseCase
import com.nwar.domain.useCase.VoteTeamInMatchUseCase
import com.nwar.umjunsik.ui.fragment.GameScheduleFragment
import com.nwar.umjunsik.viewModel.factory.GameScheduleViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.GameScheduleViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class GameScheduleModule() {
    @Provides
    fun viewModel(fragment: GameScheduleFragment, factory: GameScheduleViewModelFactory) =
        ViewModelProviders.of(fragment, factory)[GameScheduleViewModel::class.java]

    @Provides
    fun factory(
        loadGameScheduleListUseCase: LoadGameScheduleListUseCase,
        voteTeamInMatchUseCase: VoteTeamInMatchUseCase,
        likeMatchUseCase: LikeMatchUseCase
    ) = GameScheduleViewModelFactory(loadGameScheduleListUseCase, voteTeamInMatchUseCase, likeMatchUseCase)

    @Provides
    fun loadGameScheduleUseCase(mainSchedule: Scheduler) = LoadGameScheduleListUseCase(mainSchedule)

    @Provides
    fun voteTeamInMatchUseCase(mainSchedule: Scheduler) = VoteTeamInMatchUseCase(mainSchedule)

    @Provides
    fun likeMatchUseCase(mainSchedule: Scheduler) = LikeMatchUseCase(mainSchedule)
}