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

class SemiDetachedHomesActivity : AppCompatActivity() {

    var semiDetachedHome1:CheckBox? = null
    var semiDetachedHome2:CheckBox? = null
    var semiDetachedHome3:CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semi_detached_homes)
        semiDetachedHome1 = findViewById<CheckBox>(R.id.checkBox1_sd1)
        semiDetachedHome2 = findViewById<CheckBox>(R.id.checkBox2_sd2)
        semiDetachedHome3 = findViewById<CheckBox>(R.id.checkbox3_sd3)
        val checkoutBtn = findViewById<Button>(R.id.check_Out_Btn)
        var title = "Semi Detached Home"


        checkoutBtn.setOnClickListener {
            check(it)
            intent = Intent(applicationContext, CheckOutActivity::class.java)
            //intent.putExtra("selected", result)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }

    fun check(view: View?) { //saving information from checkboxes to further process on checkout page
        val myPreference = getSharedPreferences("info", 0)
        //prepare it for edit by creating an Edit object
        val preferenceEditor = myPreference.edit()
        val semiDetached1State = semiDetachedHome1!!.isChecked
        val semiDetached2State = semiDetachedHome2!!.isChecked
        val semiDetached3State = semiDetachedHome3!!.isChecked
        preferenceEditor.putBoolean("semiDetached1State", semiDetached1State)
        preferenceEditor.putString("semiDetached1Name", semiDetachedHome1!!.text as String?)
        preferenceEditor.putBoolean("semiDetached2State", semiDetached2State)
        preferenceEditor.putString("semiDetached2Name", semiDetachedHome2!!.text as String?)
        preferenceEditor.putBoolean("semiDetached3State", semiDetached3State)
        preferenceEditor.putString("semiDetached3Name", semiDetachedHome3!!.text as String?)

        preferenceEditor.commit()
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