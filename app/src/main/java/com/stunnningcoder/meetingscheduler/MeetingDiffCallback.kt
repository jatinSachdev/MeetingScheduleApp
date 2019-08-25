package com.stunnningcoder.meetingscheduler

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by JS on 8/25/19.
 */
class MeetingDiffCallback : DiffUtil.ItemCallback<MeetingModel>() {
    override fun areItemsTheSame(oldItem: MeetingModel, newItem: MeetingModel): Boolean {
        return oldItem.description == newItem.description
    }

    override fun areContentsTheSame(oldItem: MeetingModel, newItem: MeetingModel): Boolean {
         return oldItem == newItem
    }
}