package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.LoadVideoURLUseCase

class GameLiveViewModelFactory(val loadVideoURLUseCase: LoadVideoURLUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(loadVideoURLUseCase::class.java).newInstance(loadVideoURLUseCase)
}