package com.nwar.umjunsik.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.User
import com.nwar.domain.useCase.CheckDuplicateIdUseCase
import com.nwar.domain.useCase.CheckDuplicateNicknameUseCase
import com.nwar.domain.useCase.SignUpUseCase
import com.nwar.umjunsik.extend.extendFunction.isNotEmpty
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class SignupViewModel(val checkDuplIdUseCase : CheckDuplicateIdUseCase, val signUpUseCase: SignUpUseCase, val checkDuplNicknameUseCase : CheckDuplicateNicknameUseCase) : BaseViewModel() {

    val id = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordChecking = MutableLiveData<String>()
    val nickName = MutableLiveData<String>()
    val isDuplicateId = MutableLiveData<Boolean?>(null)
    val isDuplicateNickName = MutableLiveData<Boolean?>(null)
    val isSignUp = MutableLiveData<Boolean?>(null)

    private val checkDuplicateIdSubscriber get() = Subscriber<Boolean>({
        isDuplicateId.postValue(it)
    },{},{
        toast.postValue(it?.message)
        isDuplicateId.postValue(false)
    })

    private val checkDuplicateNicknameSubscriber get() = Subscriber<Boolean>({
        isDuplicateNickName.postValue(it)
    },{},{
        toast.postValue(it?.message)
        isDuplicateNickName.postValue(false)
    })

    private val signUpSubscriber get() = Subscriber<User>({
        isSignUp.postValue(true)
    },{},{
        toast.postValue(it?.message)
        isSignUp.postValue(false)
    })

    override fun registerUseCase() {
        registerUseCase(signUpUseCase, checkDuplNicknameUseCase, checkDuplIdUseCase)
    }

    fun checkDuplicateId() {
        id.value?.let { checkDuplIdUseCase.excute(it, checkDuplicateIdSubscriber) }
    }

    fun checkDuplicateNickName() {
        nickName.value?.let { checkDuplNicknameUseCase.excute(it, checkDuplicateNicknameSubscriber) }
    }

    fun requestSignUp() {
        if(id.isNotEmpty() && password.isNotEmpty() && password.value==passwordChecking.value && nickName.isNotEmpty() && isDuplicateId.value==true && isDuplicateNickName.value==true) {
            val user = User(userId = id.value!!, password = password.value!!, nickName = nickName.value!!)
            signUpUseCase.excute(user, signUpSubscriber)
        }
    }
}