package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.LikeHighLightUseCase
import com.nwar.domain.useCase.LoadHighLightListUseCase

class GameHighLightViewModelFactory(val likeHighLightUseCase: LikeHighLightUseCase, val loadHighLightListUseCase: LoadHighLightListUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(likeHighLightUseCase::class.java, loadHighLightListUseCase::class.java).newInstance(likeHighLightUseCase,loadHighLightListUseCase)
}