package com.stunnningcoder.meetingscheduler

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by JS on 8/24/19.
 */
interface ApiInterface {


    @GET("schedule")
    fun getScheduledMeetings(@Query("date") date : String): Call<List<MeetingModel>>
}