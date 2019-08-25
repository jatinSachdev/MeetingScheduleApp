package com.stunnningcoder.meetingscheduler.di

import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.stunnningcoder.meetingscheduler.ApiInterface
import com.stunnningcoder.meetingscheduler.MeetingRepository
import com.stunnningcoder.meetingscheduler.MeetingViewModel
import com.stunnningcoder.meetingscheduler.ViewImplFactory
import dagger.Module
import dagger.Provides

/**
 * Created by JS on 8/24/19.
 */

@Module
class ActivityModule(val activity: FragmentActivity, val supportFragmentManager: FragmentManager) {


    @Provides
    fun getViewFactory(layoutInflater: LayoutInflater, meetingViewModel: MeetingViewModel): ViewImplFactory {
        return ViewImplFactory(layoutInflater, supportFragmentManager, meetingViewModel)
    }

    @Provides
    fun getInflater(): LayoutInflater {
        return LayoutInflater.from(activity)
    }

    @Provides
    fun getMeetingRepository(apiInterface: ApiInterface): MeetingRepository {
      return MeetingRepository(apiInterface)
    }

}