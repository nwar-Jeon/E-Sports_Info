package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.LoadTeamListForFollowUseCase

class TeamFollowViewModelFactory(val useCase: LoadTeamListForFollowUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(useCase::class.java).newInstance(useCase)
}