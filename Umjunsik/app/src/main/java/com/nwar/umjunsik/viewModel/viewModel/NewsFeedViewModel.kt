package com.nwar.umjunsik.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.dummyData.getNewsFeedList
import com.nwar.domain.entity.NewsFeed
import com.nwar.domain.useCase.LikeNewsFeedUseCase
import com.nwar.domain.useCase.LoadGameScheduleListUseCase
import com.nwar.domain.useCase.LoadNewsFeedListUseCase
import com.nwar.umjunsik.extend.extendFunction.*
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class NewsFeedViewModel(val likeNewsFeedUseCase: LikeNewsFeedUseCase, val loadNewsFeedListUseCase: LoadNewsFeedListUseCase) : BaseViewModel() {

    val newsFeedList = MutableLiveData<MutableList<ObservableField<NewsFeed>>>()
    val tempNewsFeedList = mutableListOf<ObservableField<NewsFeed>>()

    val likeNewsFeedSubscriber get() = Subscriber<NewsFeed>(
            observeAction = {
                newsFeedList.value!!.filter { item ->
                    item.get() == it
                }.forEach { item ->
                    item.doActionAndNotifyChange { newsFeed ->
                        newsFeed.likeCount = it.likeCount
                        newsFeed.toggleLiked()
                    }
                }
            })

    val loadNewsFeedSubscriber get() = Subscriber<NewsFeed>(
            observeAction = { tempNewsFeedList.add(ObservableField(it)) },
            completeAction = { newsFeedList.postValue(tempNewsFeedList) },
            errorAction = { toast.postValue(it?.message) })

    override fun registerUseCase() = registerUseCase(likeNewsFeedUseCase, loadNewsFeedListUseCase)

    override fun onCreate() {
        super.onCreate()
        loadNewsFeedListUseCase.excute(Unit, loadNewsFeedSubscriber)
    }

    fun requireLikeClick(position: Int) {
        val newsFeed = newsFeedList[position].get()!!
        likeNewsFeedUseCase.excute(newsFeed to newsFeed.isLiked, likeNewsFeedSubscriber)
    }
}