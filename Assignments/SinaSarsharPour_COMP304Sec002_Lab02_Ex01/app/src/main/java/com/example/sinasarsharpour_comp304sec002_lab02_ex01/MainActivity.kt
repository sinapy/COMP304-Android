package com.example.sinasarsharpour_comp304sec002_lab02_ex01

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val enterBtn = findViewById<Button>(R.id.enter_btn);

        enterBtn.setOnClickListener {
            intent = Intent(applicationContext, HomeSelectActivity::class.java)
            startActivity(intent)

            val sharedPreferences: SharedPreferences = this.getSharedPreferences("info", Context.MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
        }
    }
}