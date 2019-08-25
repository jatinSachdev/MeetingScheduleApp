package com.stunnningcoder.meetingscheduler

import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.stunnningcoder.meetingscheduler.databinding.ActivityMainBinding

/**
 * Created by JS on 8/24/19.
 */

class MeetingScheduleViewImp(
    layoutInflater: LayoutInflater,
    layoutId: Int,
    meetingViewModel: MeetingViewModel
) : BaseViewImpl() {

    init {
        val binding = DataBindingUtil.inflate<ActivityMainBinding>(layoutInflater, layoutId, null, false)
        binding.setVariable(BR.meetingViewModel, meetingViewModel)
        rootView = binding.root
        Toast.makeText(rootView.context, "Done", Toast.LENGTH_SHORT).show()

    }
}

