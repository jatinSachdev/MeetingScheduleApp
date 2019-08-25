package com.stunnningcoder.meetingscheduler

import androidx.fragment.app.Fragment
import com.stunnningcoder.meetingscheduler.di.ActivityComponent
import com.stunnningcoder.meetingscheduler.di.ActivityModule
import com.stunnningcoder.meetingscheduler.di.ApplicationComponent
import java.lang.RuntimeException

/**
 * Created by JS on 8/25/19.
 */
abstract class BaseFragment : Fragment() {

    protected fun getActivityComponent(): ActivityComponent {
        return activity?.let {activity ->
             getApplicationComponent().activityComponent(ActivityModule(activity, activity.supportFragmentManager))
        } ?: throw RuntimeException("Unable to get Activity Component")

    }


    private fun getApplicationComponent(): ApplicationComponent {
        return (activity?.application as MeetingSchedulerApplication).applicationComponent
    }


}