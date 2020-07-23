package com.nwar.umjunsik.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nwar.domain.useCase.CheckDuplicateIdUseCase
import com.nwar.domain.useCase.CheckDuplicateNicknameUseCase
import com.nwar.domain.useCase.SignUpUseCase

class SignupViewModelFactory(
    val checkDuplIdUseCase: CheckDuplicateIdUseCase,
    val signUpUseCase: SignUpUseCase,
    val checkDuplNicknameUseCase: CheckDuplicateNicknameUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = modelClass.getConstructor(
        checkDuplIdUseCase::class.java,
        signUpUseCase::class.java,
        checkDuplNicknameUseCase::class.java
    ).newInstance(checkDuplIdUseCase, signUpUseCase, checkDuplNicknameUseCase)
}