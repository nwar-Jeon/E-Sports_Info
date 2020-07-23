package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.LoadTeamListForFollowUseCase
import com.nwar.umjunsik.ui.fragment.TeamFollowFragment
import com.nwar.umjunsik.viewModel.factory.TeamFollowViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.TeamFollowViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class TeamFollowModule() {
    @Provides
    fun viewModel(fragment : TeamFollowFragment, factory : TeamFollowViewModelFactory) : TeamFollowViewModel = ViewModelProviders.of(fragment, factory)[TeamFollowViewModel::class.java]

    @Provides
    fun factory(useCase : LoadTeamListForFollowUseCase) : TeamFollowViewModelFactory = TeamFollowViewModelFactory(useCase)

    @Provides
    fun loadTeamListForFollowUseCase(mainScheduler : Scheduler) = LoadTeamListForFollowUseCase(mainScheduler)
}