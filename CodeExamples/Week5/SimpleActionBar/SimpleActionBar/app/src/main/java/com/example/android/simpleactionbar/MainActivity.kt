package com.example.android.simpleactionbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create the action bar
        val actionBar: android.app.ActionBar? = getActionBar()
        //make the icon and title in the action bar clickable
        //actionBar.setDisplayHomeAsUpEnabled(true);
        //actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.hide();
        //actionBar.show(); //---show it again---
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        createMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return menuChoice(item)
    }

    private fun createMenu(menu: Menu) {
        val mnu1: MenuItem = menu.add(0, 0, 0, "Item 1")
        run {
            mnu1.setIcon(R.drawable.ic_launcher)
            //Sets how this item should display in the presence of an Action Bar.
            mnu1.setShowAsAction(
                MenuItem.SHOW_AS_ACTION_IF_ROOM or
                        MenuItem.SHOW_AS_ACTION_WITH_TEXT
            )
        }
        val mnu2: MenuItem = menu.add(0, 1, 1, "Item 2")
        run {
            mnu2.setIcon(R.drawable.ic_launcher)
            mnu2.setShowAsAction(
                MenuItem.SHOW_AS_ACTION_IF_ROOM or
                        MenuItem.SHOW_AS_ACTION_WITH_TEXT
            )
        }
        val mnu3: MenuItem = menu.add(0, 2, 2, "Item 3")
        run {
            //mnu3.setIcon(R.drawable.ic_launcher);
            mnu3.setShowAsAction(
                MenuItem.SHOW_AS_ACTION_IF_ROOM or
                        MenuItem.SHOW_AS_ACTION_WITH_TEXT
            )
        }
        val mnu4: MenuItem = menu.add(0, 3, 3, "Item 4")
        run {
            mnu4.setShowAsAction(
                MenuItem.SHOW_AS_ACTION_IF_ROOM or
                        MenuItem.SHOW_AS_ACTION_WITH_TEXT
            )
        }
        val mnu5: MenuItem = menu.add(0, 4, 4, "Item 5")
        run {
            mnu5.setShowAsAction(
                MenuItem.SHOW_AS_ACTION_IF_ROOM or
                        MenuItem.SHOW_AS_ACTION_WITH_TEXT
            )
        }
    }

    private fun menuChoice(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                Toast.makeText(
                    this,
                    "You clicked on the Application icon",
                    Toast.LENGTH_LONG
                ).show()
                val i = Intent(this, MainActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)
                return true
            }
            0 -> {
                Toast.makeText(
                    this, "You clicked on Item 1",
                    Toast.LENGTH_LONG
                ).show()
                return true
            }
            1 -> {
                Toast.makeText(
                    this, "You clicked on Item 2",
                    Toast.LENGTH_LONG
                ).show()
                return true
            }
            2 -> {
                Toast.makeText(
                    this, "You clicked on Item 3",
                    Toast.LENGTH_LONG
                ).show()
                return true
            }
            3 -> {
                Toast.makeText(
                    this, "You clicked on Item 4",
                    Toast.LENGTH_LONG
                ).show()
                return true
            }
            4 -> {
                Toast.makeText(
                    this, "You clicked on Item 5",
                    Toast.LENGTH_LONG
                ).show()
                return true
            }
        }
        return false
    }
}
