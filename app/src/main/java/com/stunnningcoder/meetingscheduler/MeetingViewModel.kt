package com.stunnningcoder.meetingscheduler

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import javax.inject.Inject

/**
 * Created by JS on 8/25/19.
 */
const val TAG_SUCCESS = "SUCCESS"
const val TAG_FAILURE ="FAILURE"
class MeetingViewModel @Inject constructor(val meetingRepository: MeetingRepository) : ViewModel() {

    val todayMeetings: MutableLiveData<List<MeetingModel>> = MutableLiveData<List<MeetingModel>>()

    var scheduleMeetingModel = MutableLiveData<MeetingModel>().also { it.value = MeetingModel() }


    var daysFromCurrent: AtomicInteger = AtomicInteger()

    fun getData(days: Int = daysFromCurrent.get()) {
        val date = MeetingHelper.getDate(DATE_FORMAT_DD_MM_YYYY_API, days)
        GlobalScope.launch {
            val data = async(Dispatchers.IO) {
                meetingRepository.getData(date)
            }
            todayMeetings.postValue(data.await())
        }

    }
}