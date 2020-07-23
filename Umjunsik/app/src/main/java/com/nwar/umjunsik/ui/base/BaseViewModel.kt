package com.nwar.umjunsik.ui.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nwar.domain.useCase.UseCase
import com.nwar.umjunsik.lifecycle.LifecycleListener

abstract class BaseViewModel() : ViewModel(), LifecycleListener {
    val toast = MutableLiveData<String>()
    val useCaseList = arrayListOf<UseCase<out Any, out Any>>()

    override fun apply(event: Lifecycle.Event) {
        when(event) {
            Lifecycle.Event.ON_CREATE -> onCreate()
            Lifecycle.Event.ON_START -> onStart()
            Lifecycle.Event.ON_RESUME -> onResume()
            Lifecycle.Event.ON_PAUSE -> onPause()
            Lifecycle.Event.ON_STOP -> onStop()
            Lifecycle.Event.ON_DESTROY -> onDestroy()
        }
    }

    open fun onCreate() {
        registerUseCase()
    }

    abstract fun registerUseCase()

    protected fun registerUseCase(vararg useCases : UseCase<out Any, out Any>) {
        useCases.forEach { useCaseList.add(it) }
    }

    open fun onStart() {}

    open fun onResume() {
        toast.postValue(null)
    }

    open fun onPause() {
        toast.postValue(null)
    }

    open fun onStop() {}

    open fun onDestroy() {
        disposeObserverOfUseCase()
    }

    private fun disposeObserverOfUseCase() {
        useCaseList.forEach { it.dispose() }
    }
}