package com.nwar.umjunsik.viewModel.viewModel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.nwar.domain.entity.GameSchedule
import com.nwar.domain.useCase.LikeMatchUseCase
import com.nwar.domain.useCase.LoadGameScheduleListUseCase
import com.nwar.domain.useCase.VoteTeamInMatchUseCase
import com.nwar.umjunsik.extend.extendFunction.doActionAndNotifyChange
import com.nwar.umjunsik.extend.extendFunction.get
import com.nwar.umjunsik.ui.base.BaseViewModel
import com.nwar.umjunsik.viewModel.subscriber.Subscriber

class GameScheduleViewModel(val loadGameScheduleUseCase : LoadGameScheduleListUseCase, val voteTeamInMatch : VoteTeamInMatchUseCase, val likeMatchUseCase: LikeMatchUseCase) : BaseViewModel() {

    val scheduleList = MutableLiveData<MutableList<ObservableField<GameSchedule>>>()
    val tempScheduleList = mutableListOf<ObservableField<GameSchedule>>()

    val loadGameScheduleSubscriber get() = Subscriber<GameSchedule>({
        tempScheduleList.add(ObservableField(it))
    },{
        scheduleList.postValue(tempScheduleList)
    },{
        toast.postValue(it?.message)
    })

    val voteTeamInMatchSubscriber get() =  Subscriber<GameSchedule>({
        scheduleList.value?.forEach {item ->
            if (item.get()==it) {
                item.doActionAndNotifyChange {  }
            }
        }
    }, {}, {
        toast.postValue(it?.message)
    })

    val likeClickSubscriber get() = Subscriber<GameSchedule>({
        scheduleList.value?.forEach {item ->
            if (item.get()==it) {
                item.doActionAndNotifyChange { it.likeToggle() }
            }
        }
    },{},{
        toast.postValue(it?.message)
    })

    override fun registerUseCase() {
        registerUseCase(loadGameScheduleUseCase, likeMatchUseCase, likeMatchUseCase)
    }

    override fun onCreate() {
        super.onCreate()
        scheduleList.postValue(tempScheduleList)
        loadGameScheduleUseCase.excute(Unit, loadGameScheduleSubscriber)
    }

    fun requireLikeClick(position : Int) {
        val schedule = getScheduleAtPosition(position)
        val isAlreadyLike = schedule.isLiked
        likeMatchUseCase.excute(schedule to isAlreadyLike, likeClickSubscriber)
    }

    fun requireVoteBlueTeam(position : Int) {
        val schedule = getScheduleAtPosition(position)
        val team = schedule.blueTeam
        voteTeamInMatch.excute(schedule to team, voteTeamInMatchSubscriber)
    }

    fun requireVoteRedTeam(position : Int) {
        val schedule = getScheduleAtPosition(position)
        val team = schedule.redTeam
        voteTeamInMatch.excute(schedule to team, voteTeamInMatchSubscriber)
    }

    private fun getScheduleAtPosition(position : Int) = scheduleList.value!![position].get()!!
}