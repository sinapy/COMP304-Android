package com.example.buttonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //Step 01: Declaration
    private lateinit var buttonLogIn: Button
    private lateinit var buttonLogSignUp: Button
    private lateinit var buttonCancel: Button
    private lateinit var buttonExit: Button
    private lateinit var buttonStop: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Step 02: Set up references
        buttonLogIn = findViewById(R.id.buttonLogIn)
        buttonLogSignUp = findViewById(R.id.buttonSignUp)
        buttonCancel = findViewById(R.id.buttonCancel)
        buttonExit = findViewById(R.id.buttonExit)
        buttonStop = findViewById(R.id.buttonStop)

        // Step 03: Set up eventListener
        buttonLogIn.setOnClickListener() {
            Toast.makeText(this, " LOG IN BUTTON CLICKED", Toast.LENGTH_SHORT).show()
        } // end event listener

    } // end onCreate()

    fun buttonSignUpOnClick(view: View) {
        Toast.makeText(this, " SIGN UP BUTTON CLICKED", Toast.LENGTH_SHORT).show()
    }

    fun buttonOnClick(view: View) {
        when (view.id) {
            R.id.buttonCancel ->
                Toast.makeText(this, "CANCEL BUTTON CLICKED!", Toast.LENGTH_SHORT).show()

            R.id.buttonExit -> {
                val myToast = Toast.makeText(this, "BUTTON EXIT CLICKED!", Toast.LENGTH_SHORT)
                myToast.show()
            }
            R.id.buttonStop ->
                Toast.makeText(this, "BUTTON STOP CLICKED!", Toast.LENGTH_SHORT).show()


        } // end When
    } // end ButtonOnClick()
}

