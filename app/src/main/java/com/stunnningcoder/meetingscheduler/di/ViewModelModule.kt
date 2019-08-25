package com.stunnningcoder.meetingscheduler.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stunnningcoder.meetingscheduler.MeetingViewModel
import com.stunnningcoder.meetingscheduler.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by JS on 8/25/19.
 */
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MeetingViewModel::class)
    abstract fun bindMyViewModel(myViewModel: MeetingViewModel): ViewModel

}