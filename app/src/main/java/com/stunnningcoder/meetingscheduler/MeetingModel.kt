package com.stunnningcoder.meetingscheduler

import com.google.gson.annotations.SerializedName

/**
 * Created by JS on 8/24/19.
 */
data class MeetingModel(
    @SerializedName("start_time") var startTime: String = "",
    @SerializedName("end_time") var endTime: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("participants") var participants: List<String> = emptyList(),
     var meetingDate : String = ""
)


