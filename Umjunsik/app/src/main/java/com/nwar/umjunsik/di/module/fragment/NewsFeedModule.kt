package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.LikeNewsFeedUseCase
import com.nwar.domain.useCase.LoadNewsFeedListUseCase
import com.nwar.umjunsik.ui.fragment.NewsFeedFragment
import com.nwar.umjunsik.viewModel.factory.NewsFeedViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.NewsFeedViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class NewsFeedModule() {
    @Provides
    fun viewModel(fragment : NewsFeedFragment, factory : NewsFeedViewModelFactory) = ViewModelProviders.of(fragment, factory)[NewsFeedViewModel::class.java]

    @Provides
    fun factory(likeNewsFeedUseCase : LikeNewsFeedUseCase, loadNewsFeedListUseCase: LoadNewsFeedListUseCase) = NewsFeedViewModelFactory(likeNewsFeedUseCase, loadNewsFeedListUseCase)

    @Provides
    fun likeNewsFeedUseCase(mainScheduler : Scheduler) = LikeNewsFeedUseCase(mainScheduler)

    @Provides
    fun loadNewsFeedUseCase(mainScheduler: Scheduler) = LoadNewsFeedListUseCase(mainScheduler)
}