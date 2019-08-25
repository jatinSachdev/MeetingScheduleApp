package com.stunnningcoder.meetingscheduler

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stunnningcoder.meetingscheduler.databinding.FragmentMeetingListBinding
import javax.inject.Inject

class MeetingListFragment : BaseFragment() {

    private var listener: OnFragmentInteractionListener? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var binding: FragmentMeetingListBinding

    lateinit var viewModel: MeetingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_meeting_list, container, false)
        activity?.let { activity ->
            viewModel = ViewModelProviders.of(activity, viewModelFactory)[MeetingViewModel::class.java]
            binding.setVariable(BR.meetingData, viewModel)

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("fragment init", viewModel.toString())
        viewModel.todayMeetings.observe(activity as MainActivity, Observer { list ->
            if (list.isEmpty()) {
                binding.rvMeetingList.visibility = View.GONE
                binding.textNoMeeting.visibility = View.VISIBLE
            } else {
                Toast.makeText(activity, " list " + list.size, Toast.LENGTH_LONG).show()
                binding.rvMeetingList.visibility = View.VISIBLE
                binding.textNoMeeting.visibility = View.GONE
                (binding.rvMeetingList.adapter as MeetingListAdapter).submitList(list)
            }

        })

        binding.rvMeetingList.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = MeetingListAdapter(MeetingDiffCallback())
        }
    }

    /* fun onButtonPressed() {
         listener?.onFragmentInteraction()
     }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(action : String)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MeetingListFragment()
    }
}
