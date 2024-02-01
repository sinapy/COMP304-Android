package com.example.explicitintentexample02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references
        val editTexUserName = findViewById<EditText>(R.id.editTextUserName)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        // Set up event listener

        buttonLogin.setOnClickListener(){
            intent = Intent(this, EmployeeDetails::class.java)
            intent.putExtra("USER_NAME", editTexUserName.text.toString() )
            intent.putExtra("E_MAIL", editTextEmail.text.toString() )
            startActivity(intent)
        } //end event listener

    } // end onCreate()
} // end MainActivity