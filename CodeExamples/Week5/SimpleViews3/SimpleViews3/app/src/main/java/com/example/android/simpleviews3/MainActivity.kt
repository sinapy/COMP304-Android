package com.example.android.simpleviews3

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //read the string-array from resources
        val programs = resources.getStringArray(R.array.programs)
        //create the array adapter to hold array items
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line, programs
        )
        //create the auto text view object
        val autoCompletTextView = findViewById<View>(R.id.txtPrograms) as AutoCompleteTextView
        //connect the adapter with autocompletetextview object
        //and set the number of characters needed to type
        autoCompletTextView.threshold = 2
        //bind the array to the autocomplete textview
        autoCompletTextView.setAdapter(adapter)
    }
}
