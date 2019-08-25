package com.stunnningcoder.meetingscheduler

import androidx.appcompat.app.AppCompatActivity
import com.stunnningcoder.meetingscheduler.di.ActivityComponent
import com.stunnningcoder.meetingscheduler.di.ActivityModule
import com.stunnningcoder.meetingscheduler.di.ApplicationComponent

open class BaseActivity : AppCompatActivity() {

    protected fun getActivityComponent(): ActivityComponent {
        return getApplicationComponent().activityComponent(ActivityModule( this, supportFragmentManager))
    }


    private fun getApplicationComponent(): ApplicationComponent {
        return (application as MeetingSchedulerApplication).applicationComponent
    }




}
