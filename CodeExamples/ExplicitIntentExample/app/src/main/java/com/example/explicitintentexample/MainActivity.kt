package com.example.explicitintentexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get reference

        val buttonNext = findViewById<Button>(R.id.buttonNext)

        // Set up event listener
        buttonNext.setOnClickListener() {
            intent = Intent(this, SecondActivity::class.java)

            startActivity(intent)
        } // end Event Listener
    } // end onCreate()
} // end mainActivity