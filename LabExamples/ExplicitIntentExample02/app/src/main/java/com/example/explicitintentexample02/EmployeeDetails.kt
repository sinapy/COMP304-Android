package com.example.explicitintentexample02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EmployeeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        // Get References
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextSalary = findViewById<EditText>(R.id.editTextSalary)
        val buttonLoginDetails = findViewById<Button>(R.id.buttonLoginDetails)


        // Set  up event handlers
        buttonLoginDetails.setOnClickListener() {
            var intent = intent
            // Extract the values
            var uname = intent.getStringExtra("USER_NAME")
            var email = intent.getStringExtra("E_MAIL")
            Toast.makeText(this, "USER NAME: "  + uname + "\nE_Mail: " + email, Toast.LENGTH_SHORT).show()
        } // end event listener
    } // end onCreate()
} // end Employee Details