package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.useCase.SignInUseCase
import com.nwar.umjunsik.ui.fragment.SigninFragment
import com.nwar.umjunsik.viewModel.factory.SignInViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.SignInViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class SignInModule() {
    @Provides
    fun viewModel(fragment : SigninFragment, factory : SignInViewModelFactory) = ViewModelProviders.of(fragment, factory)[SignInViewModel::class.java]

    @Provides
    fun factory(signInUseCase : SignInUseCase) = SignInViewModelFactory(signInUseCase)

    @Provides
    fun signInUseCase(mainScheduler: Scheduler) = SignInUseCase(mainScheduler)
}