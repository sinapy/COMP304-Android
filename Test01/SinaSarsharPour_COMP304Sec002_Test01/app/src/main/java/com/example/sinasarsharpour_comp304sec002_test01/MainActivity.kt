package com.example.sinasarsharpour_comp304sec002_test01

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    var yr = 0
    var month = 0
    var day = 0
    lateinit var pickADateButton: Button
    lateinit var programStartDateEditText: EditText
    lateinit var nextButton: Button
    lateinit var programIdEditText: EditText
    lateinit var schoolNameEditText: EditText
    lateinit var programDurationSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val today: Calendar = Calendar.getInstance()
        yr = today.get(Calendar.YEAR)
        month = today.get(Calendar.MONTH)
        day = today.get(Calendar.DAY_OF_MONTH)

        pickADateButton = findViewById(R.id.pickADateButton)
        programStartDateEditText = findViewById(R.id.programStartDateEditText)
        nextButton = findViewById(R.id.nextButton)

        pickADateButton.setOnClickListener {
            showDialog(DATE_DIALOG_ID)
        }

        nextButton.setOnClickListener {
            val isFormValid = ValidateForm()


        }
    }

    private fun ValidateForm(): Boolean {
        if (this.pricePerUnitEdit.text.toString().toInt() <= 0){
            this.pricePerUnitEdit.error = "price per unit should be above 0"
            return false
        }

        if (this.quantityEdit.text.toString().toInt() !in 1..10){
            this.quantityEdit.error = "quantity should be between 1 and 10 (inclusive)"
            return false
        }

        return true
    }

    override fun onCreateDialog(id: Int): Dialog? {
        when (id) {
            DATE_DIALOG_ID -> return DatePickerDialog(
                this, mDateSetListener, yr, month, day
            )
        }
        return null
    }

    private val mDateSetListener: DatePickerDialog.OnDateSetListener =
        //anonymous implementation of the OnDateSetListener
        DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

            //event handler method
            yr = year
            month = monthOfYear
            day = dayOfMonth
            programStartDateEditText.setText("$yr/$month/$day")
        }
    companion object {
        val TIME_DIALOG_ID = 0
        val DATE_DIALOG_ID = 1
    }
}