package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       //Get the reference
        val editTextUrl = findViewById<EditText>(R.id.editTextUrl)
       val buttonDisplay = findViewById<Button>(R.id.buttonDisplay)

        // Set up event listener
        buttonDisplay.setOnClickListener(){
          //  val url = editTextUrl.text.toString()
          //  intent = Intent(Intent.ACTION_VIEW, Uri.parse(editTextUrl.text.toString()))
            intent = Intent(Intent.ACTION_VIEW, Uri.parse(editTextUrl.text.toString()))
            startActivity(intent)
        }
    }
}