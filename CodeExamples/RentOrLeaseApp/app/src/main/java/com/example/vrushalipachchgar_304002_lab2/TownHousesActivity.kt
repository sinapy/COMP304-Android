package com.example.vrushalipachchgar_304002_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class TownHousesActivity : AppCompatActivity() {
    var townHouse1: CheckBox? = null
    var townHouse2: CheckBox? = null
    var townHouse3: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town_houses)

        townHouse1 = findViewById<CheckBox>(R.id.cB1_townhouse)
        townHouse2 = findViewById<CheckBox>(R.id.cB2_townhouse)
        townHouse3 = findViewById<CheckBox>(R.id.cB3_townhouse)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)
        var title = "Town House"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)

            intent.putExtra("title",title)
            startActivity(intent)
        }
    }

    fun check(view: View?) { //saving information from checkboxes to further process on checkout page
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val prefEditor = myPreference.edit()
        val townHouse1State = townHouse1!!.isChecked
        val townHouse2State = townHouse2!!.isChecked
        val townHouse3State = townHouse3!!.isChecked
        prefEditor.putBoolean("townhouse1State", townHouse1State)
        prefEditor.putString("townhouse1Name", townHouse1!!.text as String?)
        prefEditor.putBoolean("townhouse2State", townHouse2State)
        prefEditor.putString("townhouse2Name", townHouse2!!.text as String?)
        prefEditor.putBoolean("townhouse3State", townHouse3State)
        prefEditor.putString("townhouse3Name", townHouse3!!.text as String?)

        prefEditor.commit()
        Toast.makeText(this, "Added to checkout", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_house_type,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.m_apartments -> {
                Toast.makeText(this,"Displaying Apartments", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,ApartmentHomeActivity::class.java)
                startActivity(intent)
            }
            R.id.m_detached_homes ->{
                Toast.makeText(this,"Displaying Detached Homes", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,DetachedHomesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_semidetached_homes -> {
                Toast.makeText(this,"Displaying Semi-detached Homes", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,SemiDetachedHomesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_condos -> {
                Toast.makeText(this,"Displaying Condominum", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,CondominiumActivity::class.java)
                startActivity(intent)
            }
            R.id.m_town_houses -> {
                Toast.makeText(this,"Displaying Town housed", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,TownHousesActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
