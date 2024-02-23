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

class CondominiumActivity : AppCompatActivity() {

    var checkBoxCondo1:CheckBox? = null
    var checkBoxCondo2:CheckBox? = null
    var checkBoxCondo3:CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condominium)

        checkBoxCondo1 = findViewById<CheckBox>(R.id.checkBox1_c1)
        checkBoxCondo2 = findViewById<CheckBox>(R.id.checkBox2_c2)
        checkBoxCondo3 = findViewById<CheckBox>(R.id.checkBox3_c3)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)

        var title = "Condominium"

        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)
            //intent.putExtra("selected", result)
            startActivity(intent)
        }
    }

    fun check(view: View?){
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()
        val condo1State = checkBoxCondo1!!.isChecked
        val condo2State = checkBoxCondo2!!.isChecked
        val condo3State = checkBoxCondo3!!.isChecked
        preferenceEditor.putBoolean("condo1State", condo1State)
        preferenceEditor.putString("condo1Name", checkBoxCondo1!!.text as String?)
        preferenceEditor.putBoolean("condo2State", condo2State)
        preferenceEditor.putString("condo2Name", checkBoxCondo2!!.text as String?)
        preferenceEditor.putBoolean("condo3State", condo3State)
        preferenceEditor.putString("condo3Name", checkBoxCondo3!!.text as String?)

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