package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.CheckDuplicateNicknameUseCase
import com.nwar.umjunsik.ui.fragment.ChangeNicknameFragment
import com.nwar.umjunsik.viewModel.factory.ChangeNicknameViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.ChangeNicknameViewModel
import dagger.Module
import dagger.Provides

import io.reactivex.rxjava3.core.Scheduler

@Module
class ChangeNicknameModule() {
    @Provides
    fun provideViewModel(fragment : ChangeNicknameFragment, factory : ChangeNicknameViewModelFactory) : ChangeNicknameViewModel = ViewModelProviders.of(fragment, factory)[ChangeNicknameViewModel::class.java]

    @Provides
    fun provideFactory(useCase : CheckDuplicateNicknameUseCase) : ChangeNicknameViewModelFactory = ChangeNicknameViewModelFactory(useCase)

    @Provides
    fun checkDuplNicknameUseCase(scheduler: Scheduler) = CheckDuplicateNicknameUseCase(scheduler)
}