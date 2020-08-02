package com.nwar.umjunsik.di.module.fragment

import androidx.lifecycle.ViewModelProviders
import com.nwar.domain.repository.AccountRepository
import com.nwar.domain.repository.CheckDuplicateRepository
import com.nwar.domain.useCase.CheckDuplicateIdUseCase
import com.nwar.domain.useCase.CheckDuplicateNicknameUseCase
import com.nwar.domain.useCase.SignUpUseCase
import com.nwar.umjunsik.ui.fragment.SignupFragment
import com.nwar.umjunsik.viewModel.factory.SignupViewModelFactory
import com.nwar.umjunsik.viewModel.viewModel.SignupViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler

@Module
class SignUpModule() {
    @Provides
    fun viewModel(fragment: SignupFragment, factory: SignupViewModelFactory) =
        ViewModelProviders.of(fragment, factory)[SignupViewModel::class.java]

    @Provides
    fun factory(
        idUseCase: CheckDuplicateIdUseCase,
        nicknameUseCase: CheckDuplicateNicknameUseCase,
        signUpUseCase: SignUpUseCase
    ) = SignupViewModelFactory(
        checkDuplIdUseCase = idUseCase,
        checkDuplNicknameUseCase = nicknameUseCase,
        signUpUseCase = signUpUseCase
    )

    @Provides
    fun checkDuplIdUseCase(scheduler: Scheduler, checkDuplicateRepository: CheckDuplicateRepository) = CheckDuplicateIdUseCase(scheduler, checkDuplicateRepository)

    @Provides
    fun checkDuplNicknameUseCase(scheduler: Scheduler, checkDuplicateRepository: CheckDuplicateRepository) = CheckDuplicateNicknameUseCase(scheduler, checkDuplicateRepository)

    @Provides
    fun signUpUseCase(scheduler: Scheduler, accountRepository: AccountRepository) = SignUpUseCase(scheduler, accountRepository)
}