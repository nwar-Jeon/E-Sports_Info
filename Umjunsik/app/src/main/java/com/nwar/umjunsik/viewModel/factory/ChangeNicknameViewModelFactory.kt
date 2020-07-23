package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.CheckDuplicateNicknameUseCase

class ChangeNicknameViewModelFactory(val checkDupNickUseCase : CheckDuplicateNicknameUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(checkDupNickUseCase::class.java).newInstance(checkDupNickUseCase)
}