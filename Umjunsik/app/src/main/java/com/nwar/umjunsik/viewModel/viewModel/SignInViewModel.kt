package com.nwar.umjunsik.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.User
import com.nwar.domain.useCase.SignInUseCase
import com.nwar.umjunsik.R
import com.nwar.umjunsik.extend.extendFunction.isNotEmpty
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class SignInViewModel(val signInUseCase: SignInUseCase) : BaseViewModel() {

    val id = MutableLiveData("")
    val password = MutableLiveData("")
    val nextFragmentAction = MutableLiveData<Int?>()
    val isLoginSuccessed = MutableLiveData<Boolean?>()

    private val signInSubscriber get() = Subscriber<User>({

    }, {
        isLoginSuccessed.postValue(true)
        nextFragmentAction.postValue(R.id.action_signinFragment_to_mainFragment)
    }, {
        isLoginSuccessed.postValue(false)
        toast.postValue(it?.message)
    })

    override fun registerUseCase() {
        registerUseCase(signInUseCase)
    }

    override fun onResume() {
        super.onResume()
        isLoginSuccessed.postValue(null)
    }

    override fun onPause() {
        super.onPause()
        nextFragmentAction.postValue(null)
    }

    fun requestLogin() {
        if(id.isNotEmpty() && password.isNotEmpty()) signInUseCase.excute(User(userId = id.value!!, password = password.value!!), signInSubscriber)
    }

    fun toSignup() {
        nextFragmentAction.postValue(R.id.action_signinFragment_to_signupFragment)
    }
}