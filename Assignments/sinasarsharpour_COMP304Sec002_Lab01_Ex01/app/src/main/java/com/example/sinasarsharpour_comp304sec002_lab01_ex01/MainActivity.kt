package com.example.sinasarsharpour_comp304sec002_lab01_ex01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNext = findViewById<Button>(R.id.button)
        val fullName = findViewById<EditText>(R.id.fullNameEdit)
        val emailAddress = findViewById<EditText>(R.id.emailEdit)
        val address = findViewById<EditText>(R.id.addressEdit)

        // Set up event listener
        buttonNext.setOnClickListener() {
            intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("FULL_NAME", fullName.text.toString() )
            intent.putExtra("EMAIL_ADDRESS", emailAddress.text.toString() )
            intent.putExtra("ADDRESS", address.text.toString() )
            startActivity(intent)
        } // end Event Listener
    } // end onCreate()
} // end MainActivity