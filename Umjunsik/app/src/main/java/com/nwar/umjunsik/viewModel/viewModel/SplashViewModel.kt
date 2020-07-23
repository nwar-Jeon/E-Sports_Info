package com.nwar.umjunsik.viewModel.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nwar.umjunsik.R
import com.nwar.umjunsik.ui.base.BaseViewModel
import kotlinx.coroutines.*

class SplashViewModel() : BaseViewModel() {

    val nextFragmentAction = MutableLiveData<Int>()

    override fun onCreate() {
        super.onCreate()
        existAccount()
    }

    override fun registerUseCase() {

    }

    private fun existAccount() {
        GlobalScope.launch {
            kotlinx.coroutines.delay(2000)
            nextFragmentAction.postValue(R.id.action_splash_to_signinFragment)
        }
        GlobalScope.launch {
            // 로그인 정보 확인.
        }
    }
}