package com.stunnningcoder.meetingscheduler

import android.app.Application
import com.stunnningcoder.meetingscheduler.di.ApplicationComponent
import com.stunnningcoder.meetingscheduler.di.ApplicationModule
import com.stunnningcoder.meetingscheduler.di.DaggerApplicationComponent
import dagger.internal.DaggerCollections

/**
 * Created by JS on 8/24/19.
 */
class MeetingSchedulerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}