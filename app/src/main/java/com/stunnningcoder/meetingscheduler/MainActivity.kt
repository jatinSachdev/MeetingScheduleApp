package com.stunnningcoder.meetingscheduler

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.stunnningcoder.meetingscheduler.databinding.ActivityMainBinding
import javax.inject.Inject

const val ACTION_BACK_PRESS = "ACTION_BACK_PRESS"
class MainActivity : BaseActivity(), MeetingListFragment.OnFragmentInteractionListener, ScheduleMeetingFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(action : String) {
       if(action == ACTION_BACK_PRESS){
           viewImplFactory.popScheduleFragment()
       }
    }

    @Inject
    lateinit var viewImplFactory: ViewImplFactory
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var meetingViewModel: MeetingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityComponent().inject(this)
        meetingViewModel = ViewModelProviders.of(this, viewModelFactory)[MeetingViewModel::class.java]
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.setVariable(BR.meetingViewModel, meetingViewModel)
        meetingViewModel.getData()
        viewImplFactory.inflateMeetingList()
        Log.d("activity init", meetingViewModel.toString())
        meetingViewModel.todayMeetings.observe(this, Observer {
            binding.textCurrentDate.text =
                MeetingHelper.getDate(DATE_FORMAT_DD_MM_YYYY_UI, meetingViewModel.daysFromCurrent.get())
        })
        binding.actionSchedule.setOnClickListener {
            viewImplFactory.inflateScheduleMeeting()
        }
    }

}
