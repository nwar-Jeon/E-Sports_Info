package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.LikeItemRepository
import com.nwar.domain.repository.LoadListRepository
import com.nwar.domain.repository.VoteRepository
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
    fun loadGameScheduleUseCase(mainSchedule: Scheduler, loadListRepository: LoadListRepository) = LoadGameScheduleListUseCase(mainSchedule, loadListRepository)

    @Provides
    fun voteTeamInMatchUseCase(mainSchedule: Scheduler, voteRepository: VoteRepository) = VoteTeamInMatchUseCase(mainSchedule, voteRepository)

    @Provides
    fun likeMatchUseCase(mainSchedule: Scheduler, likeItemRepository: LikeItemRepository) = LikeMatchUseCase(mainSchedule, likeItemRepository)
}