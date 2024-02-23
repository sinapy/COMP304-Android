package com.example.sinasarsharpour_comp304sec002_lab02_ex01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AutoAccessoriesActivity : AppCompatActivity() {
    lateinit var checkBoxAutoAccessories1: CheckBox
    lateinit var checkBoxAutoAccessories2: CheckBox
    lateinit var checkBoxAutoAccessories3: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_accessories)

        checkBoxAutoAccessories1 = findViewById(R.id.checkBox1_auto_accessories)
        checkBoxAutoAccessories2 = findViewById(R.id.checkBox2_auto_accessories)
        checkBoxAutoAccessories3 = findViewById(R.id.checkBox3_auto_accessories)

        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)

        var actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Accessories"

        checkBoxAutoAccessories1.setOnClickListener {
            check(it)
        }
        checkBoxAutoAccessories2.setOnClickListener {
            check(it)
        }
        checkBoxAutoAccessories3.setOnClickListener {
            check(it)
        }

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)

            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    fun check(view: View?) {
        val myPreference = getSharedPreferences("info", 0)
        val preferenceEditor = myPreference.edit()

        val autoAccessory1State = checkBoxAutoAccessories1.isChecked
        val autoAccessory2State = checkBoxAutoAccessories2.isChecked
        val autoAccessory3State = checkBoxAutoAccessories3.isChecked

        preferenceEditor.putBoolean("autoAccessory1State", autoAccessory1State)
        preferenceEditor.putString("autoAccessory1Name", checkBoxAutoAccessories1.text as String?)
        preferenceEditor.putBoolean("autoAccessory2State", autoAccessory2State)
        preferenceEditor.putString("autoAccessory2Name", checkBoxAutoAccessories2.text as String?)
        preferenceEditor.putBoolean("autoAccessory3State", autoAccessory3State)
        preferenceEditor.putString("autoAccessory3Name", checkBoxAutoAccessories3.text as String?)

        preferenceEditor.apply()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_auto_accessories -> {
                Toast.makeText(this, "Displaying AutoAccessoriess", Toast.LENGTH_SHORT).show();
                intent = Intent(applicationContext, AppliancesActivity::class.java)
                startActivity(intent);
            }

            R.id.m_tvs -> {
                Toast.makeText(this, "Displaying TVs", Toast.LENGTH_SHORT).show();
                intent = Intent(applicationContext, TVsActivity::class.java)
                startActivity(intent);
            }

            R.id.m_computers -> {
                Toast.makeText(this, "Displaying Computers", Toast.LENGTH_SHORT).show();
                intent = Intent(applicationContext, ComputersActivity::class.java)
                startActivity(intent);
            }

            R.id.m_furnitures -> {
                Toast.makeText(this, "Displaying Furnitures", Toast.LENGTH_SHORT).show();
                intent = Intent(applicationContext, FurnituresActivity::class.java)
                startActivity(intent);
            }

            R.id.m_auto_accessories -> {
                Toast.makeText(this, "Displaying Auto Accessories", Toast.LENGTH_SHORT).show();
                intent = Intent(applicationContext, AutoAccessoriesActivity::class.java)
                startActivity(intent);
            }
        }
        return super.onOptionsItemSelected(item)
    }
}