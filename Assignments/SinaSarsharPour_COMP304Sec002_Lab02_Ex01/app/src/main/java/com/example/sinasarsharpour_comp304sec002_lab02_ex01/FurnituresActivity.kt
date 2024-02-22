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

class FurnituresActivity : AppCompatActivity() {
    private var checkBoxFurniture1: CheckBox? = null;
    private var checkBoxFurniture2: CheckBox? = null;
    private var checkBoxFurniture3: CheckBox? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furnitures)

        checkBoxFurniture1 = findViewById(R.id.checkBox1_furnitures)
        checkBoxFurniture2 = findViewById(R.id.checkBox2_furnitures)
        checkBoxFurniture3 = findViewById(R.id.checkBox3_furnitures)

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

        val furniture1State = checkBoxFurniture1!!.isChecked
        val furniture2State = checkBoxFurniture2!!.isChecked
        val furniture3State = checkBoxFurniture3!!.isChecked

        preferenceEditor.putBoolean("furniture1State", furniture1State)
        preferenceEditor.putString("furniture1Name", checkBoxFurniture1!!.text as String?)
        preferenceEditor.putBoolean("furniture2State", furniture2State)
        preferenceEditor.putString("furniture2Name", checkBoxFurniture2!!.text as String?)
        preferenceEditor.putBoolean("furniture3State", furniture3State)
        preferenceEditor.putString("furniture3Name", checkBoxFurniture3!!.text as String?)

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