package com.stunnningcoder.meetingscheduler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stunnningcoder.meetingscheduler.databinding.ItemMeetingListBinding

/**
 * Created by JS on 8/25/19.
 */
class MeetingListAdapter(meetingDiffCallback: MeetingDiffCallback) :
    ListAdapter<MeetingModel, MeetingListAdapter.ViewHolder>(meetingDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemMeetingListBinding>(inflater, R.layout.item_meeting_list, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.meetingData = getItem(position)
    }


    class ViewHolder(val binding: ItemMeetingListBinding) : RecyclerView.ViewHolder(binding.root)
}