package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.LikeHighLightUseCase
import com.nwar.domain.useCase.LoadHighLightListUseCase
import com.nwar.umjunsik.ui.fragment.GameHighLightFragment
import com.nwar.umjunsik.viewModel.factory.GameHighLightViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.GameHighLightViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class GameHighLightModule {
    @Provides
    fun viewModel(fragment : GameHighLightFragment, factory : GameHighLightViewModelFactory) = ViewModelProviders.of(fragment, factory)[GameHighLightViewModel::class.java]

    @Provides
    fun factory(likeHighLightUseCase: LikeHighLightUseCase, loadHighLightListUseCase: LoadHighLightListUseCase) = GameHighLightViewModelFactory(likeHighLightUseCase, loadHighLightListUseCase)

    @Provides
    fun likeHighLightUseCase(mainScheduler: Scheduler) = LikeHighLightUseCase(mainScheduler)

    @Provides
    fun loadHighLightListUseCase(mainScheduler: Scheduler) = LoadHighLightListUseCase(mainScheduler)
}