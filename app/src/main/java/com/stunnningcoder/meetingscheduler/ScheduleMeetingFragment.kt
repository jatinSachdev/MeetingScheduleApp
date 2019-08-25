package com.stunnningcoder.meetingscheduler

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.stunnningcoder.meetingscheduler.databinding.FragmentScheduleMeetingBinding
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ScheduleMeetingFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class ScheduleMeetingFragment : BaseFragment() {
    private var listener: OnFragmentInteractionListener? = null

    @Inject
    lateinit var mViewModelFactory: ViewModelFactory

    lateinit var viewModel: MeetingViewModel

    lateinit var binding: FragmentScheduleMeetingBinding

    val datePickerListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
        val cal = Calendar.getInstance()
        cal.set(year, month, dayOfMonth)
        val sdf = SimpleDateFormat(DATE_FORMAT_DD_MM_YYYY_UI, Locale.US)
        viewModel.scheduleMeetingModel.value?.meetingDate = sdf.format(cal.time)
        binding.actionMeetingDate.text = sdf.format(cal.time)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_schedule_meeting, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(activity as MainActivity, mViewModelFactory)[MeetingViewModel::class.java]
        binding.setVariable(BR.scheduleViewModel, viewModel)
        binding.actionBack.setOnClickListener {
            listener?.onFragmentInteraction(ACTION_BACK_PRESS)
        }
        binding.actionMeetingDate.setOnClickListener {
            datePicker(activity as MainActivity)
        }
        binding.actionSubmit.setOnClickListener {
            val model = viewModel.scheduleMeetingModel.value
            model?.let { meetingModel ->
                if (meetingModel.meetingDate.isEmpty() || meetingModel.startTime.isEmpty() || meetingModel.endTime.isEmpty() || meetingModel.description.isEmpty()) {
                    Toast.makeText(activity, TAG_FAILURE, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, TAG_SUCCESS, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

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

    fun datePicker(activity: MainActivity) {
        val cal = Calendar.getInstance()
        DatePickerDialog(
            activity,
            datePickerListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ScheduleMeetingFragment()
    }

}
