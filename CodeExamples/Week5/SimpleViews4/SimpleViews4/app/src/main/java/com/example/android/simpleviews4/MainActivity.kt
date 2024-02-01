package com.example.android.simpleviews4

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*


class MainActivity() : AppCompatActivity() {
    var timePicker: TimePicker? = null
    var datePicker: DatePicker? = null
    var hour = 0
    var minute = 0
    var yr = 0
    var month = 0
    var day = 0

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //instantiate the date and time picker
        timePicker = findViewById<View>(R.id.timePicker) as TimePicker
        timePicker!!.setIs24HourView(true)

        // showDialog(TIME_DIALOG_ID);
        datePicker = findViewById<View>(R.id.datePicker) as DatePicker

        //---get the current date---
        val today: Calendar = Calendar.getInstance()
        yr = today.get(Calendar.YEAR)
        month = today.get(Calendar.MONTH)
        day = today.get(Calendar.DAY_OF_MONTH)
        //show the dialog
        showDialog(DATE_DIALOG_ID)
    }

    override fun onCreateDialog(id: Int): Dialog? {
        when (id) {
            TIME_DIALOG_ID -> return TimePickerDialog(
                this, mTimeSetListener, hour, minute, false
            )
            DATE_DIALOG_ID -> return DatePickerDialog(
                this, mDateSetListener, yr, month, day
            )
        }
        return null
    }

    //implement the event handling
    private val mDateSetListener: OnDateSetListener =
        //anonymous implementation of the OnDateSetListener
        OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            //event handler method
            yr = year
            month = monthOfYear
            day = dayOfMonth
            Toast.makeText(
                baseContext,
                ("You have selected : " + (month + 1) +
                        "/" + day + "/" + year),
                Toast.LENGTH_SHORT
            ).show()
        }
    private val mTimeSetListener: OnTimeSetListener =
        OnTimeSetListener { view, hourOfDay, minuteOfHour ->
            hour = hourOfDay
            minute = minuteOfHour
            val timeFormat = SimpleDateFormat("hh:mm aa")
            val date = Date(0, 0, 0, hour, minute)
            //format the date as string
            val strDate: String = timeFormat.format(date)
            //display it
            Toast.makeText(
                baseContext,
                "You have selected $strDate",
                Toast.LENGTH_SHORT
            ).show()
        }

    fun onClick(view: View?) {
        Toast.makeText(
            baseContext,
            "Date selected:" + (datePicker!!.month + 1) +
                    "/" + datePicker!!.dayOfMonth +
                    "/" + datePicker!!.year + "\n" +
                    "Time selected:" + timePicker!!.currentHour +
                    ":" + timePicker!!.currentMinute,
            Toast.LENGTH_SHORT
        ).show()
    }

    companion object {
        val TIME_DIALOG_ID = 0
        val DATE_DIALOG_ID = 1
    }
}
