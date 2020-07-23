package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.LikeNewsFeedUseCase
import com.nwar.domain.useCase.LoadNewsFeedListUseCase

class NewsFeedViewModelFactory(val newsFeedUseCase: LikeNewsFeedUseCase, val loadNewsFeedListUseCase: LoadNewsFeedListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(newsFeedUseCase::class.java, loadNewsFeedListUseCase::class.java).newInstance(newsFeedUseCase, loadNewsFeedListUseCase)
}