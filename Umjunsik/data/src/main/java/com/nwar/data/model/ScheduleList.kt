package com.nwar.data.model

import com.google.gson.annotations.SerializedName

class ScheduleList(
    @SerializedName("schedules")
    val scheduleList: List<Schedule>
) {
}