package com.example.vrushalipachchgar_304002_lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class HomeSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_select)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_house_type,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.m_apartments -> {
                Toast.makeText(this,"Displaying Apartments", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext,ApartmentHomeActivity::class.java)
                startActivity(intent)
            }
            R.id.m_detached_homes ->{
                Toast.makeText(this,"Displaying Detached Homes", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext,DetachedHomesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_semidetached_homes -> {
                Toast.makeText(this,"Displaying Semi-detached Homes", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext,SemiDetachedHomesActivity::class.java)
                startActivity(intent)
            }
            R.id.m_condos -> {
                Toast.makeText(this,"Displaying Condominum", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext,CondominiumActivity::class.java)
                startActivity(intent)
            }
            R.id.m_town_houses -> {
                Toast.makeText(this,"Displaying Town housed", Toast.LENGTH_SHORT).show()
                intent = Intent(applicationContext,TownHousesActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}