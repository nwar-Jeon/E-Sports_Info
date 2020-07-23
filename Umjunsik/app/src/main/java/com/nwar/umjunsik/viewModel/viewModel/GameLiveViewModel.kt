package com.nwar.umjunsik.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.dummyData.getLiveChattingList
import com.nwar.domain.entity.GameLiveChatting
import com.nwar.domain.useCase.LoadVideoURLUseCase
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class GameLiveViewModel(val loadVideoURLUseCase: LoadVideoURLUseCase) : BaseViewModel() {

    val videoUrl = MutableLiveData<String>()

    val chattingList = MutableLiveData<MutableList<ObservableField<GameLiveChatting>>>()

    val loadVideoURLSubscriber get() = Subscriber<String>({
        videoUrl.postValue(it)
    },{},{
        toast.postValue(it?.message)
    })

    override fun registerUseCase() {
        registerUseCase(loadVideoURLUseCase)
    }

    override fun onCreate() {
        super.onCreate()
        loadVideoURLUseCase.excute(Unit, loadVideoURLSubscriber)
        chattingList.postValue(getLiveChattingList().map { ObservableField(it) }.toMutableList())
    }
}