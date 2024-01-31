package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   // Step 01: Declaration
    lateinit var editTextNum1: EditText
    lateinit var editTextNum2: EditText
    lateinit var editTextOutput: EditText
    lateinit var buttonAdd: Button
    lateinit var buttonSub: Button
    lateinit var buttonDiv: Button
    lateinit var buttonMul: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Step 02: Get references
        editTextNum1 = findViewById(R.id.editTextNum1)
        editTextNum2 = findViewById(R.id.editTextNum2)
        editTextOutput = findViewById(R.id.editTextOutput)
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonMul = findViewById(R.id.buttonMul);

        // Step 03: Set up event listener
        buttonAdd.setOnClickListener(){

            Toast.makeText(this, "BUTTON ADD CLICKED", Toast.LENGTH_SHORT).show()
        }

    } // end onCreate()

    fun buttonOnClick(view: View) {
        Toast.makeText(this, "BUTTON SUB CLICKED", Toast.LENGTH_SHORT).show()
        val a:Int = editTextNum1.text.toString().toInt()
        val b:Int = editTextNum2.text.toString().toInt()
        when (view.id) {
            R.id.buttonAdd -> editTextOutput.setText(a + b)
            R.id.buttonSub -> editTextOutput.setText(a - b)
            R.id.buttonDiv -> editTextOutput.setText(a * b)
            R.id.buttonMul -> editTextOutput.setText(a / b)
        }
    }
} // end MainActivity