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

class ApartmentHomeActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    private var checkBoxApartment1: CheckBox? = null
    private var checkBoxApartment2: CheckBox? = null
    private var checkBoxApartment3: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apartment_home)

        checkBoxApartment1 = findViewById<CheckBox>(R.id.checkBox1_apartments)
        checkBoxApartment2 = findViewById<CheckBox>(R.id.checkBox2_apartments)
        checkBoxApartment3 = findViewById<CheckBox>(R.id.checkbox3_apartments)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)


        val actionBar: android.app.ActionBar? = getActionBar()
        if (actionBar != null) {

            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setDisplayShowHomeEnabled(true)
            actionBar.show()
        }

        var title = "Apartments"

        checkoutBtn.setOnClickListener {

            check(it);
            intent = Intent(applicationContext, CheckOutActivity::class.java)

            //intent.putExtra("selected",result)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    fun check(view: View?) {
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()

        //checking and saving info from checkboxes
        val apartment1State = checkBoxApartment1!!.isChecked
        val apartment2State = checkBoxApartment2!!.isChecked
        val apartment3State = checkBoxApartment3!!.isChecked

        preferenceEditor.putBoolean("apartment1State", apartment1State)
        preferenceEditor.putString("apartment1Name", checkBoxApartment1!!.text as String?)
        preferenceEditor.putBoolean("apartment2State", apartment2State)
        preferenceEditor.putString("apartment2Name", checkBoxApartment2!!.text as String?)
        preferenceEditor.putBoolean("apartment3State", apartment3State)
        preferenceEditor.putString("apartment3Name", checkBoxApartment3!!.text as String?)

        preferenceEditor.commit()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_house_type, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.m_apartments -> {
                Toast.makeText(this, "Displaying Apartments", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext, ApartmentHomeActivity::class.java)
                startActivity(intent)
            }

            R.id.m_detached_homes -> {
                Toast.makeText(this, "Displaying Detached Homes", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext, DetachedHomesActivity::class.java)
                startActivity(intent)
            }

            R.id.m_semidetached_homes -> {
                Toast.makeText(this, "Displaying Semi-detached Homes", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext, SemiDetachedHomesActivity::class.java)
                startActivity(intent)
            }

            R.id.m_condos -> {
                Toast.makeText(this, "Displaying Condominum", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext, CondominiumActivity::class.java)
                startActivity(intent)
            }

            R.id.m_town_houses -> {
                Toast.makeText(this, "Displaying Town housed", Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext, TownHousesActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}