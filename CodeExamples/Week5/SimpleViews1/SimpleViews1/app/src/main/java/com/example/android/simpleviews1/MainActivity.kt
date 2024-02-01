package com.example.android.simpleviews1

import android.os.Bundle
import android.text.InputFilter.AllCaps
import android.text.InputFilter.LengthFilter
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    fun btnSaved_clicked(view: View?) {
        DisplayToast("You have clicked the Save button1")
    }

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //---Button view---
        val btnOpen: Button = findViewById<View>(R.id.btnOpen) as Button
        //register the button with an event listener
        btnOpen.setOnClickListener(object : View.OnClickListener {
            //anonymous class
            //implement your event handler method
            override fun onClick(v: View?) {
                DisplayToast("You have clicked the Open button")
            }
        })

        /*
		//---Button view---
		Button btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v) {
				DisplayToast("You have clicked the Save button");
			}
		});
        */

        //---CheckBox---
        val checkBox = findViewById<View>(R.id.chkAutosave) as CheckBox
        checkBox.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if ((v as CheckBox).isChecked) DisplayToast("CheckBox is checked") else DisplayToast(
                    "CheckBox is unchecked"
                )
            }
        })

        //---RadioButton---
        val radioGroup = findViewById<View>(R.id.rdbGp1) as RadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val rb1 = findViewById<View>(R.id.rdb1) as RadioButton
            if (rb1.isChecked) {
                DisplayToast("Option 1 checked!")
            } else {
                DisplayToast("Option 2 checked!")
            }
        }

        //---ToggleButton---
        val toggleButton = findViewById<View>(R.id.toggle1) as ToggleButton
        toggleButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if ((v as ToggleButton).isChecked) DisplayToast("Toggle button is On") else DisplayToast(
                    "Toggle button is Off"
                )
            }
        })

        


    }


    private fun DisplayToast(msg: String) {
        Toast.makeText(
            baseContext, msg,
            Toast.LENGTH_SHORT
        ).show()
    }
    //



}
