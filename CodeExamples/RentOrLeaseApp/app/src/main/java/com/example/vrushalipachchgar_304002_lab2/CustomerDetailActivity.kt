package com.example.vrushalipachchgar_304002_lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CustomerDetailActivity : AppCompatActivity() {

    var userName: EditText? = null
    var userAddress: EditText? = null
    var userEmail: EditText? = null
    var userPhone: EditText? = null
    var userHobby: EditText? = null
    var userFav: EditText? = null
    var userCardNumber: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_detail)

        userName = findViewById<EditText>(R.id.customer_name)
        userAddress = findViewById<EditText>(R.id.customer_address)
        userEmail = findViewById<EditText>(R.id.customer_email)
        userPhone = findViewById<EditText>(R.id.customer_phone)
        userHobby = findViewById<EditText>(R.id.customer_hobby)
        userFav = findViewById<EditText>(R.id.customer_fav_place)
        val finalSubmit = findViewById<Button>(R.id.final_submit)

        userCardNumber = findViewById<EditText>(R.id.customer_card_no)
        val final_result = findViewById<TextView>(R.id.final_output)

        val myPreference = getSharedPreferences("info", MODE_PRIVATE)
        val preferenceEditor = myPreference.edit()

        val result:String = intent.getStringExtra("resultradiobutton").toString()
        if(result.equals("Cash")){
            userCardNumber!!.visibility = View.GONE
        }

        finalSubmit.setOnClickListener {

            if (validateData()){

                if(result.equals("credit") || result.equals("debit")){
                    if(userCardNumber!!.text.isEmpty()){
                        Toast.makeText(applicationContext,"Please enter the card number ",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        final_result.text = userName!!.text.toString() + "," + userAddress!!.text.toString() + ","+userEmail!!.text.toString() + ",\n" +userPhone!!.text.toString() +"," + userHobby!!.text.toString() +","+userFav!!.text.toString()
                        preferenceEditor.clear()

                    }

                }
                final_result.text = userName!!.text.toString() + "," + userAddress!!.text.toString() + ","+userEmail!!.text.toString() + ",\n" +userPhone!!.text.toString() +"," + userHobby!!.text.toString() +","+userFav!!.text.toString()
                preferenceEditor.clear()
                Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateData(): Boolean{

        if (userName!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your name", Toast.LENGTH_LONG).show()
            return false
        }
        if (userAddress!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your address", Toast.LENGTH_SHORT).show()
            return false
        }
        if (userEmail!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your E-mail", Toast.LENGTH_SHORT).show()
            return false
        }
        if (userPhone!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your phone number", Toast.LENGTH_SHORT).show()
            return false
        }
        if(userHobby!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your hobby", Toast.LENGTH_SHORT).show()
            return false
        }
        if (userFav!!.text.isEmpty()){
            Toast.makeText(applicationContext,"Please enter your favourite place name", Toast.LENGTH_SHORT).show()
            return false
        } else{
            return true
        }
    }
}