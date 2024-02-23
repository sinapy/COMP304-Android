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

class DetachedHomesActivity : AppCompatActivity() {
    private val sharedPreferenceFile = "kotlinsharedpreference"

    var checkBoxDetached1: CheckBox? = null
    var checkBoxDetached2: CheckBox? = null
    var checkBoxDetached3: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detached_homes)

        checkBoxDetached1 = findViewById<CheckBox>(R.id.cB1_detached)
        checkBoxDetached2 = findViewById<CheckBox>(R.id.cB2_detached)
        checkBoxDetached3 = findViewById<CheckBox>(R.id.cB3_detached)

        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)
        var title = "Detached Home"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)

            //intent.putExtra("selected", result)
            intent.putExtra("title", title)
            startActivity(intent)
        }
    }

    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()
        val detached1State = checkBoxDetached1!!.isChecked
        val detached2State = checkBoxDetached2!!.isChecked
        val detached3State = checkBoxDetached3!!.isChecked
        preferenceEditor.putBoolean("detached1State", detached1State)
        preferenceEditor.putString("detached1Name", checkBoxDetached1!!.text as String?)
        preferenceEditor.putBoolean("detached2State", detached2State)
        preferenceEditor.putString("detached2Name", checkBoxDetached2!!.text as String?)
        preferenceEditor.putBoolean("detached3State", detached3State)
        preferenceEditor.putString("detached3Name", checkBoxDetached3!!.text as String?)
        preferenceEditor.commit()
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this,"Displaying Detached Homes",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,DetachedHomesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_semidetached_homes -> {
                Toast.makeText(this,"Displaying Semi-detached Homes",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,SemiDetachedHomesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_condos -> {
                Toast.makeText(this,"Displaying Condominum",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,CondominiumActivity::class.java)
                startActivity(intent)
            }
            R.id.m_town_houses -> {
                Toast.makeText(this,"Displaying Town housed",Toast.LENGTH_SHORT).show()
                check(view = null)
                intent = Intent(applicationContext,TownHousesActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}