package com.example.sinasarsharpour_comp304sec002_lab01_ex01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.logging.Logger.global

class SecondActivity : AppCompatActivity() {

    lateinit var pricePerUnitEdit: EditText
    lateinit var quantityEdit: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        // Extract the values
        val fullName = intent.getStringExtra("FULL_NAME")
        val emailAddress = intent.getStringExtra("EMAIL_ADDRESS")
        val address = intent.getStringExtra("ADDRESS")

        val userInformationTextView = findViewById<TextView>(R.id.userInformationTextView)
        userInformationTextView.append(fullName + '\n')
        userInformationTextView.append(emailAddress + '\n')
        userInformationTextView.append(address + '\n')

        pricePerUnitEdit = findViewById(R.id.pricePerUnitEdit)
        quantityEdit = findViewById(R.id.quantityEdit)

        val calculateBtn = findViewById<Button>(R.id.calculateBtn)

        calculateBtn.setOnClickListener {
            val isFormValid = ValidateForm()

            if (isFormValid){

                val a:Int = pricePerUnitEdit.text.toString().toInt()
                val b:Int = quantityEdit.text.toString().toInt()
                val total = a * b
                userInformationTextView.append("total is $total\n")
            }
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
}