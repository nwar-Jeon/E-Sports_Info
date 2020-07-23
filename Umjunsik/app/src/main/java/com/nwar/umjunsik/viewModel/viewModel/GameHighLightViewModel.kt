package com.nwar.umjunsik.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.HighLight
import com.nwar.domain.useCase.LikeHighLightUseCase
import com.nwar.domain.useCase.LoadHighLightListUseCase
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class GameHighLightViewModel(val likeHighLightUseCase: LikeHighLightUseCase, val loadHighLightListUseCase: LoadHighLightListUseCase) : BaseViewModel() {
    val searchText = MutableLiveData<String>()

    val highlightList = MutableLiveData<MutableList<ObservableField<HighLight>>>()
    val tempHighLightList = mutableListOf<ObservableField<HighLight>>()

    val likeClickSubscriber get() = Subscriber<HighLight>({
        tempHighLightList.forEach { item ->
            if(item.get()==it) {
                item.set(it)
                item.notifyChange()
            }
        }
    },{},{
        toast.postValue(it?.message)
    })
    val searchSubscriber get() = Subscriber<HighLight>({
        tempHighLightList.add(ObservableField(it))
    },{
        highlightList.postValue(tempHighLightList)
    },{
        toast.postValue(it?.message)
    })

    override fun onCreate() {
        super.onCreate()
        highlightList.postValue(tempHighLightList)
        requireSearch()
    }

    override fun registerUseCase() {
        registerUseCase(likeHighLightUseCase, loadHighLightListUseCase)
    }

    fun requireSearch() {
        tempHighLightList.clear()
        loadHighLightListUseCase.excute(searchText.value ?: "", searchSubscriber)
    }

    fun requireLickClick(position : Int) {
        val highLight = highlightList.value!![position].get()!!
        val isAlreadyLike = highLight.isLiked
        likeHighLightUseCase.excute(highLight to isAlreadyLike, likeClickSubscriber)
    }

    fun requirePlayVideo(position : Int) {

    }
}