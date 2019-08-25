package com.stunnningcoder.meetingscheduler.di

import com.stunnningcoder.meetingscheduler.MainActivity
import com.stunnningcoder.meetingscheduler.MeetingListFragment
import com.stunnningcoder.meetingscheduler.ScheduleMeetingFragment
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by JS on 8/24/19.
 */


@Subcomponent(modules = [ActivityModule::class, ViewModelModule::class])
interface ActivityComponent{
    fun inject(activity: MainActivity)
    fun inject(fragment : MeetingListFragment)
    fun inject(fragment: ScheduleMeetingFragment)
}