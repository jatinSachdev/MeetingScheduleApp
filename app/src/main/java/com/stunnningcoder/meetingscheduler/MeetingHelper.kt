package com.stunnningcoder.meetingscheduler

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by JS on 8/25/19.
 */

const val DATE_FORMAT_DD_MM_YYYY_API = "dd/MM/yyyy"
const val DATE_FORMAT_DD_MM_YYYY_UI = "dd-MM-yyyy"

object MeetingHelper {


    fun getDate(format : String, daysFromCurrent : Int) : String{
        val calendar  = Calendar.getInstance()
        val dateFormatter = SimpleDateFormat(format, Locale.ENGLISH)
        calendar.add(Calendar.DAY_OF_YEAR, daysFromCurrent)
        return dateFormatter.format(Date(calendar.timeInMillis))
    }

}