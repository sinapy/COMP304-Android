package com.example.sinasarsharpour_comp304sec002_lab02_ex01

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_select)
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