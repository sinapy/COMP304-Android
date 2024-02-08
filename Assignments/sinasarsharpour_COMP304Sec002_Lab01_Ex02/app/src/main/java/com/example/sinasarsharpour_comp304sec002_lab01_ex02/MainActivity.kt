package com.example.sinasarsharpour_comp304sec002_lab01_ex02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var eventNameEdit: EditText
    lateinit var eventDateEdit: EditText
    lateinit var eventOrganizerEdit: EditText
    lateinit var citySpinner: Spinner
    lateinit var isCorporateCheckBox: CheckBox
    lateinit var isNonProfitCheckBox: CheckBox
    lateinit var isEducationCheckBox: CheckBox
    lateinit var rdbGp1: RadioGroup
    lateinit var rdb1: RadioButton
    lateinit var rdb2: RadioButton
    lateinit var registerButton: Button
    lateinit var resetButton: Button
    lateinit var enteredDetailsTextView: TextView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eventNameEdit = findViewById(R.id.eventNameEdit)
        eventDateEdit = findViewById(R.id.eventDateEdit)
        eventOrganizerEdit = findViewById(R.id.eventOrganizerEdit)
        citySpinner = findViewById(R.id.citySpinner)
        isCorporateCheckBox = findViewById(R.id.isCorporateCheckBox)
        isNonProfitCheckBox = findViewById(R.id.isNonProfitCheckBox)
        isEducationCheckBox = findViewById(R.id.isEducationCheckBox)
        rdbGp1 = findViewById(R.id.rdbGp1)
        rdb1 = findViewById(R.id.rdb1)
        rdb2 = findViewById(R.id.rdb2)
        registerButton = findViewById(R.id.registerButton)
        resetButton = findViewById(R.id.resetButton)
        enteredDetailsTextView = findViewById(R.id.enteredDetailsTextView)

        registerButton.setOnClickListener {
            val isFormValid: Boolean = ValidateForm()

            if (isFormValid) {
                val str: String =
                    """event name: ${eventNameEdit.text}
                    |event date: ${eventDateEdit.text}
                    |event organizer: ${eventOrganizerEdit.text}
                    |city: ${citySpinner.selectedItem}
                    |event type: ${if(isCorporateCheckBox.isChecked) isCorporateCheckBox.text.toString() + ", " else ""}${if(isNonProfitCheckBox.isChecked) isNonProfitCheckBox.text.toString() + ", " else ""}                           ${if(isEducationCheckBox.isChecked) isEducationCheckBox.text.toString() + ", " else ""}
                    |event format: ${if(rdb1.isChecked) rdb1.text else rdb2.text}
                """.trimMargin()
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
                enteredDetailsTextView.text = ""
                enteredDetailsTextView.append(str)
            }
        }

        resetButton.setOnClickListener {
            eventNameEdit.setText("")
            eventDateEdit.setText("")
            eventOrganizerEdit.setText("")
            citySpinner.setSelection(0)
            if (isCorporateCheckBox.isChecked) isCorporateCheckBox.toggle()
            if (isNonProfitCheckBox.isChecked) isNonProfitCheckBox.toggle()
            if (isEducationCheckBox.isChecked) isEducationCheckBox.toggle()
            rdbGp1.clearCheck()
        }
    }

    private fun ValidateForm(): Boolean {
        if (!isCorporateCheckBox.isChecked and !isNonProfitCheckBox.isChecked and !isEducationCheckBox.isChecked){
            isCorporateCheckBox.error = "Select at least one checkbox"
            isNonProfitCheckBox.error = "Select at least one checkbox"
            isEducationCheckBox.error = "Select at least one checkbox"
            return false
        }

        return true
    }
}