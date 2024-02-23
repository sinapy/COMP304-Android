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

class AppliancesActivity : AppCompatActivity() {
    lateinit var checkBoxAppliance1: CheckBox
    lateinit var checkBoxAppliance2: CheckBox
    lateinit var checkBoxAppliance3: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appliances)

        checkBoxAppliance1 = findViewById(R.id.checkBox1_appliances)
        checkBoxAppliance2 = findViewById(R.id.checkBox2_appliances)
        checkBoxAppliance3 = findViewById(R.id.checkBox3_appliances)

        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)

        var actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Accessories"

        checkBoxAppliance1.setOnClickListener {
            check(it)
        }
        checkBoxAppliance2.setOnClickListener {
            check(it)
        }
        checkBoxAppliance3.setOnClickListener {
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

        val appliance1State = checkBoxAppliance1.isChecked
        val appliance2State = checkBoxAppliance2.isChecked
        val appliance3State = checkBoxAppliance3.isChecked

        preferenceEditor.putBoolean("appliance1State", appliance1State)
        preferenceEditor.putString("appliance1Name", checkBoxAppliance1.text as String?)
        preferenceEditor.putBoolean("appliance2State", appliance2State)
        preferenceEditor.putString("appliance2Name", checkBoxAppliance2.text as String?)
        preferenceEditor.putBoolean("appliance3State", appliance3State)
        preferenceEditor.putString("appliance3Name", checkBoxAppliance3.text as String?)

        preferenceEditor.apply()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_appliances -> {
                Toast.makeText(this, "Displaying Appliances", Toast.LENGTH_SHORT).show();
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
