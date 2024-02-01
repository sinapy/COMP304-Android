package com.example.android.spinnertest

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create the spinner object
        val spin = findViewById<View>(R.id.provinces_spinner) as Spinner
        //create a button object
        val submit: Button = findViewById<View>(R.id.submit) as Button
        //handle the  click event
        submit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                //get the spinner view as text view
                val text_sel = spin.selectedView as TextView
                //get the text from the spinner view
                Toast.makeText(
                    this@MainActivity, """
 Province = ${text_sel.text}""", Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }
}
