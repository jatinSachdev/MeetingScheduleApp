package com.stunnningcoder.meetingscheduler

/**
 * Created by JS on 8/25/19.
 */
class MeetingRepository(val apiInterface: ApiInterface) {

    fun getData(
        date: String
    ): List<MeetingModel> {
        val response = apiInterface.getScheduledMeetings(date).execute()
        return if (response.isSuccessful) {
            response.body() as List<MeetingModel>
        } else {
            emptyList()
        }
    }
}