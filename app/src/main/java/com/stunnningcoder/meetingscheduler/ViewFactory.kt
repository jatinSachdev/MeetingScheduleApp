package com.stunnningcoder.meetingscheduler

import android.view.LayoutInflater
import androidx.fragment.app.FragmentManager
import java.lang.IllegalArgumentException

/**
 * Created by JS on 8/24/19.
 */

class ViewImplFactory(
    private val layoutInflater: LayoutInflater,
    private val fragmentManager: FragmentManager,
    private val meetingViewModel: MeetingViewModel
) {

    @Suppress("UNCHECKED_CAST")
    fun <T : BaseViewImpl>getViewImpl(type : Class<T>) : T{
        val viewImpl : BaseViewImpl
        if(type == MeetingScheduleViewImp::class.java){
            viewImpl = MeetingScheduleViewImp(layoutInflater, R.layout.activity_main, meetingViewModel)
        }else {
            throw IllegalArgumentException()
        }
     return viewImpl as T
    }

    fun inflateMeetingList(){
        fragmentManager.beginTransaction().add(R.id.fragmentContainer, MeetingListFragment.newInstance()).commit()
    }

    fun inflateScheduleMeeting() {
        fragmentManager.beginTransaction().add(R.id.mainContainer, ScheduleMeetingFragment.newInstance()).addToBackStack(ScheduleMeetingFragment::class.java.canonicalName).commit()
    }

    fun popScheduleFragment(){
        fragmentManager.popBackStack()
    }
}