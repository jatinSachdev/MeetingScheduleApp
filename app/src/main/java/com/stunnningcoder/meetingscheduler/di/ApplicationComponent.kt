package com.stunnningcoder.meetingscheduler.di

import dagger.Component
import javax.inject.Singleton

/**
 * Created by JS on 8/24/19.
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{

    fun activityComponent(activityModule: ActivityModule) : ActivityComponent

}