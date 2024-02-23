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

class ComputersActivity : AppCompatActivity() {
    lateinit var checkBoxComputer1: CheckBox
    lateinit var checkBoxComputer2: CheckBox
    lateinit var checkBoxComputer3: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_computers)

        checkBoxComputer1 = findViewById(R.id.checkBox1_computers)
        checkBoxComputer2 = findViewById(R.id.checkBox2_computers)
        checkBoxComputer3 = findViewById(R.id.checkBox3_computers)

        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)

        var actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Accessories"

        checkBoxComputer1.setOnClickListener {
            check(it)
        }
        checkBoxComputer2.setOnClickListener {
            check(it)
        }
        checkBoxComputer3.setOnClickListener {
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

        val computer1State = checkBoxComputer1.isChecked
        val computer2State = checkBoxComputer2.isChecked
        val computer3State = checkBoxComputer3.isChecked

        preferenceEditor.putBoolean("computer1State", computer1State)
        preferenceEditor.putString("computer1Name", checkBoxComputer1.text as String?)
        preferenceEditor.putBoolean("computer2State", computer2State)
        preferenceEditor.putString("computer2Name", checkBoxComputer2.text as String?)
        preferenceEditor.putBoolean("computer3State", computer3State)
        preferenceEditor.putString("computer3Name", checkBoxComputer3.text as String?)

        preferenceEditor.commit()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_product_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_computers -> {
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