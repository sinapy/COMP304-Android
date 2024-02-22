package com.example.sinasarsharpour_comp304sec002_lab02_ex01

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckOutActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPreferenceFile, Context.MODE_PRIVATE)

        clearSharedPreferences()
        val selectProduct = findViewById<View>(R.id.selectProduct) as TextView
        selectProduct.visibility = View.INVISIBLE
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        val titleTextView = findViewById<TextView>(R.id.tV)

        val myPreference = getSharedPreferences("info", MODE_PRIVATE)
        val appliance1State = myPreference.getBoolean("appliance1State", false)
        val appliance1Name = myPreference.getString("appliance1Name", "")
        val appliance2State = myPreference.getBoolean("appliance2State", false)
        val appliance2Name = myPreference.getString("appliance2Name", "")
        val appliance3State = myPreference.getBoolean("appliance3State", false)
        val appliance3Name = myPreference.getString("appliance3Name", "")

        val autoAccessory1State = myPreference.getBoolean("autoAccessory1State", false)
        val autoAccessory1Name = myPreference.getString("autoAccessory1Name", "")
        val autoAccessory2State = myPreference.getBoolean("autoAccessory2State", false)
        val autoAccessory2Name = myPreference.getString("autoAccessory2Name", "")
        val autoAccessory3State = myPreference.getBoolean("autoAccessory3State", false)
        val autoAccessory3Name = myPreference.getString("autoAccessory3Name", "")

        val computer1State = myPreference.getBoolean("computer1State", false)
        val computer1Name = myPreference.getString("computer1Name", "")
        val computer2State = myPreference.getBoolean("computer2State", false)
        val computer2Name = myPreference.getString("computer2Name", "")
        val computer3State = myPreference.getBoolean("computer3State", false)
        val computer3Name = myPreference.getString("computer3Name", "")

        val furniture1State = myPreference.getBoolean("furniture1State", false)
        val furniture1Name = myPreference.getString("furniture1Name", "")
        val furniture2State = myPreference.getBoolean("furniture2State", false)
        val furniture2Name = myPreference.getString("furniture2Name", "")
        val furniture3State = myPreference.getBoolean("furniture3State", false)
        val furniture3Name = myPreference.getString("furniture3Name", "")

        val tv1State = myPreference.getBoolean("tv1State", false)
        val tv1Name = myPreference.getString("tv1Name", "")
        val tv2State = myPreference.getBoolean("tv2State", false)
        val tv2Name = myPreference.getString("tv2Name", "")
        val tv3State = myPreference.getBoolean("tv3State", false)
        val tv3Name = myPreference.getString("tv3Name", "")

        var options_exist = false;
        val rg = findViewById<View>(R.id.radioGroupCombo) as RadioGroup

        //checking every checkbox and adding radio button if it's checked
        if (appliance1State) {
            val rb1 = RadioButton(this)
            rb1.setText(appliance1Name)
            rb1.id = 1
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb1, params)
            options_exist = true
        }
        if (appliance2State) {
            val rb2 = RadioButton(this)
            rb2.setText(appliance2Name)
            rb2.id = 2
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb2, params)
            options_exist = true
        }

        if (appliance3State) {
            val rb12 = RadioButton(this)
            rb12.setText(appliance3Name)
            rb12.id = 12
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb12, params)
            options_exist = true
        }

        if (computer1State) {
            val rb3 = RadioButton(this)
            rb3.setText(computer1Name)
            rb3.id = 3
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb3, params)
            options_exist = true
        }
        if (computer2State) {
            val rb4 = RadioButton(this)
            rb4.setText(computer2Name)
            rb4.id = 4
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb4, params)
            options_exist = true
        }

        if (computer3State) {
            val rb14 = RadioButton(this)
            rb14.setText(computer3Name)
            rb14.id = 14
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb14, params)
            options_exist = true
        }

        if (tv1State) {
            val rb5 = RadioButton(this)
            rb5.setText(tv1Name)
            rb5.id = 5
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb5, params)
            options_exist = true
        }

        if (tv2State) {
            val rb6 = RadioButton(this)
            rb6.setText(tv2Name)
            rb6.id = 6
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb6, params)
            options_exist = true
        }

        if (tv3State) {
            val rb11 = RadioButton(this)
            rb11.setText(tv3Name)
            rb11.id = 11
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb11, params)
            options_exist = true
        }

        if (autoAccessory1State) {
            val rb7 = RadioButton(this)
            rb7.setText(autoAccessory1Name)
            rb7.id = 7
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb7, params)
            options_exist = true
        }

        if (autoAccessory2State) {
            val rb8 = RadioButton(this)
            rb8.setText(autoAccessory2Name)
            rb8.id = 8
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb8, params)
            options_exist = true
        }

        if (autoAccessory3State) {
            val rb13 = RadioButton(this)
            rb13.setText(autoAccessory3Name)
            rb13.id = 13
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb13, params)
            options_exist = true
        }

        if (furniture1State) {
            val rb9 = RadioButton(this)
            rb9.setText(furniture1Name)
            rb9.id = 9
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb9, params)
            options_exist = true
        }

        if (furniture2State) {
            val rb10 = RadioButton(this)
            rb10.setText(furniture2Name)
            rb10.id = 10
            val params = RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT
            )
            rg.addView(rb10, params)
            options_exist = true
        }

        if (furniture3State) {
            val rb15 = RadioButton(this)
            rb15.setText(furniture3Name)
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
            selectProduct.visibility = View.VISIBLE
        }

        nextBtn.setOnClickListener {
            if (!options_exist) {
                Toast.makeText(applicationContext, "Please select at least one", Toast.LENGTH_SHORT).show()
            }
            else{
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