package com.example.vrushalipachchgar_304002_lab2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class CheckOutActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)

        clearSharedPreferences()
        val selectHouse = findViewById<View>(R.id.selectHouse) as TextView
        selectHouse.visibility = View.INVISIBLE
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        val titleTextView = findViewById<TextView>(R.id.tV)

        val myPreference = getSharedPreferences("info", MODE_PRIVATE)
        val apartment1State = myPreference.getBoolean("apartment1State", false)
        val apartment1Name = myPreference.getString("apartment1Name", "")
        val apartment2State = myPreference.getBoolean("apartment2State", false)
        val apartment2Name = myPreference.getString("apartment2Name", "")
        val apartment3State = myPreference.getBoolean("apartment3State", false)
        val apartment3Name = myPreference.getString("apartment3Name", "")

        val condo1State = myPreference.getBoolean("condo1State", false)
        val condo1Name = myPreference.getString("condo1Name", "")
        val condo2State = myPreference.getBoolean("condo2State", false)
        val condo2Name = myPreference.getString("condo2Name", "")
        val condo3State = myPreference.getBoolean("condo3State", false)
        val condo3Name = myPreference.getString("condo3Name", "")

        val detached1State = myPreference.getBoolean("detached1State", false)
        val detached1Name = myPreference.getString("detached1Name", "")
        val detached2State = myPreference.getBoolean("detached2State", false)
        val detached2Name = myPreference.getString("detached2Name", "")
        val detached3State = myPreference.getBoolean("detached3State", false)
        val detached3Name = myPreference.getString("detached3Name", "")

        val semiDetached1State = myPreference.getBoolean("semiDetached1State", false)
        val semiDetached1Name = myPreference.getString("semiDetached1Name", "")
        val semiDetached2State = myPreference.getBoolean("semiDetached1State", false)
        val semiDetached2Name = myPreference.getString("semiDetached2Name", "")
        val semiDetached3State = myPreference.getBoolean("semiDetached3State", false)
        val semiDetached3Name = myPreference.getString("semiDetached3Name", "")

        val townHouse1State = myPreference.getBoolean("townHouse1State", false)
        val townHouse1Name = myPreference.getString("townHouse1Name", "")
        val townHouse2State = myPreference.getBoolean("townHouse2State", false)
        val townHouse2Name = myPreference.getString("townHouse2Name", "")
        val townHouse3State = myPreference.getBoolean("townHouse1State", false)
        val townHouse3Name = myPreference.getString("townHouse3Name", "")


        var options_exist = false // to check whether there are selected options at all
        val rg = findViewById<View>(R.id.radioGroupCombo) as RadioGroup

        //checking every checkbox and adding radio button if it's checked
        if (apartment1State) {
            val rb1 = RadioButton(this)
            rb1.setText(apartment1Name)
            rb1.id = 1
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb1, params)
            options_exist = true
        }
        if (apartment2State) {
            val rb2 = RadioButton(this)
            rb2.setText(apartment2Name)
            rb2.id = 2
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb2, params)
            options_exist = true
        }

        if (apartment3State) {
            val rb12 = RadioButton(this)
            rb12.setText(apartment3Name)
            rb12.id = 12
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb12, params)
            options_exist = true
        }

        if (condo1State) {
            val rb3 = RadioButton(this)
            rb3.setText(condo1Name)
            rb3.id = 3
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb3, params)
            options_exist = true
        }
        if (condo2State) {
            val rb4 = RadioButton(this)
            rb4.setText(condo2Name)
            rb4.id = 4
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb4, params)
            options_exist = true
        }

        if (condo3State) {
            val rb14 = RadioButton(this)
            rb14.setText(condo3Name)
            rb14.id = 14
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb14, params)
            options_exist = true
        }

        if (detached1State) {
            val rb5 = RadioButton(this)
            rb5.setText(detached1Name)
            rb5.id = 5
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb5, params)
            options_exist = true
        }

        if (detached2State) {
            val rb6 = RadioButton(this)
            rb6.setText(detached2Name)
            rb6.id = 6
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb6, params)
            options_exist = true
        }

        if (detached3State) {
            val rb11 = RadioButton(this)
            rb11.setText(detached3Name)
            rb11.id = 11
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb11, params)
            options_exist = true
        }

        if (semiDetached1State) {
            val rb7 = RadioButton(this)
            rb7.setText(semiDetached1Name)
            rb7.id = 7
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb7, params)
            options_exist = true
        }

        if (semiDetached2State) {
            val rb8 = RadioButton(this)
            rb8.setText(semiDetached2Name)
            rb8.id = 8
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb8, params)
            options_exist = true
        }

        if (semiDetached3State) {
            val rb13 = RadioButton(this)
            rb13.setText(semiDetached3Name)
            rb13.id = 13
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb13, params)
            options_exist = true
        }

        if (townHouse1State) {
            val rb9 = RadioButton(this)
            rb9.setText(townHouse1Name)
            rb9.id = 9
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb9, params)
            options_exist = true
        }

        if (townHouse2State) {
            val rb10 = RadioButton(this)
            rb10.setText(townHouse2Name)
            rb10.id = 10
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb10, params)
            options_exist = true
        }

        if (townHouse3State) {
            val rb15 = RadioButton(this)
            rb15.setText(townHouse3Name)
            rb15.id = 15
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb15, params)
            options_exist = true
        }

        if (!options_exist) {
            nextBtn.visibility = View.INVISIBLE
            selectHouse.visibility = View.VISIBLE
        }

        nextBtn.setOnClickListener {
            if (options_exist==false){
                Toast.makeText(applicationContext,"Please select atleast one", Toast.LENGTH_SHORT).show()
            }else{
                intent = Intent(applicationContext,PaymentActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun clearSharedPreferences() {
        // Clear the shared preferences file
        val sharedPref = getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)
        sharedPref.edit().clear().apply()
    }
}