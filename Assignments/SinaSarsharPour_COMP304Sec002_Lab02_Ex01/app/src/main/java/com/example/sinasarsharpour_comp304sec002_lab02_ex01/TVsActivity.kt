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

class TVsActivity : AppCompatActivity() {
    private var checkBoxTV1: CheckBox? = null;
    private var checkBoxTV2: CheckBox? = null;
    private var checkBoxTV3: CheckBox? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tvs)

        checkBoxTV1 = findViewById(R.id.checkBox1_tvs)
        checkBoxTV2 = findViewById(R.id.checkBox2_tvs)
        checkBoxTV3 = findViewById(R.id.checkBox3_tvs)

        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)

        var actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Accessories"

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

        val tv1State = checkBoxTV1!!.isChecked
        val tv2State = checkBoxTV2!!.isChecked
        val tv3State = checkBoxTV3!!.isChecked

        preferenceEditor.putBoolean("tv1State", tv1State)
        preferenceEditor.putString("tv1Name", checkBoxTV1!!.text as String?)
        preferenceEditor.putBoolean("tv2State", tv2State)
        preferenceEditor.putString("tv2Name", checkBoxTV2!!.text as String?)
        preferenceEditor.putBoolean("tv3State", tv3State)
        preferenceEditor.putString("tv3Name", checkBoxTV3!!.text as String?)

        preferenceEditor.commit()
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