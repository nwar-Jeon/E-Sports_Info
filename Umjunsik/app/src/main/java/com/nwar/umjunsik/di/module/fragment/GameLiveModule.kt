package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.LoadVideoURLUseCase
import com.nwar.umjunsik.ui.fragment.GameLiveFragment
import com.nwar.umjunsik.viewModel.factory.GameLiveViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.GameLiveViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class GameLiveModule() {
    @Provides
    fun viewModel(fragment : GameLiveFragment, factory : GameLiveViewModelFactory) = ViewModelProviders.of(fragment, factory)[GameLiveViewModel::class.java]

    @Provides
    fun factory(loadVideoURLUseCase: LoadVideoURLUseCase) = GameLiveViewModelFactory(loadVideoURLUseCase)

    @Provides
    fun loadVideoURLUseCase(mainScheduler: Scheduler) = LoadVideoURLUseCase(mainScheduler)
}