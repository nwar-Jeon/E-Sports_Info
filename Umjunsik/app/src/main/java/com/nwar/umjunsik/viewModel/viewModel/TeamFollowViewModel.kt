package com.nwar.umjunsik.viewModel.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.FollowTeam
import com.nwar.domain.useCase.LoadTeamListForFollowUseCase
import com.nwar.umjunsik.extend.extendFunction.doActionAndNotifyChange
import com.nwar.umjunsik.extend.extendFunction.get
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class TeamFollowViewModel(val loadTeamListUseCase : LoadTeamListForFollowUseCase) : BaseViewModel() {

    val backNavigator = MutableLiveData(false)

    val teamList = MutableLiveData<MutableList<ObservableField<FollowTeam>>>()

    val tempList = mutableListOf<ObservableField<FollowTeam>>()

    val loadTeamSubscriber get() = Subscriber<FollowTeam>({
        tempList.add(ObservableField(it))
    },{
        teamList.postValue(tempList)
    },{
        toast.postValue(it?.message)
    })

    override fun registerUseCase() {
        registerUseCase(loadTeamListUseCase)
    }

    override fun onCreate() {
        super.onCreate()
        backNavigator.postValue(false)
        loadTeamListUseCase.excute(Unit, loadTeamSubscriber)
    }

    override fun onPause() {
        super.onPause()
        backNavigator.postValue(false)
    }

    fun requireBackNavigate() {
        backNavigator.postValue(true)
    }

    fun requireFollow(position : Int) {
        teamList[position].doActionAndNotifyChange { it.followToggle() }
    }
}