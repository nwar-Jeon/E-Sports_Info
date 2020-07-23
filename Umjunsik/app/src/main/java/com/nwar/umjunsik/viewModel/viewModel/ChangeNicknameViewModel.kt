package com.nwar.umjunsik.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.useCase.CheckDuplicateNicknameUseCase
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class ChangeNicknameViewModel(val checkDupNickUseCase: CheckDuplicateNicknameUseCase) : BaseViewModel() {

    val isDuplicateNickname = MutableLiveData<Boolean?>()
    val inputNickname = MutableLiveData<String>()
    val currentNickname = MutableLiveData("불러오는 중..")
    val backNavigateUpListener = MutableLiveData(false)

    val isDuplicateNicknameSubscriber
        get() = Subscriber<Boolean>({ isDuplicateNickname.postValue(it) }, {}, { toast.postValue(it?.message) })

    override fun registerUseCase() { registerUseCase(checkDupNickUseCase) }

    override fun onResume() {
        super.onResume()
        isDuplicateNickname.postValue(null)
        backNavigateUpListener.postValue(false)
    }

    fun requireCheckDuplicateNickname() {
        inputNickname.value?.let { checkDupNickUseCase.excute(it, isDuplicateNicknameSubscriber) }
    }

    fun requireBackNavigate() {
        backNavigateUpListener.postValue(true)
    }
}