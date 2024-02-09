package com.example.android.simplemenuexample
//
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//
class MainActivity : AppCompatActivity() {
    var shouldKeepMenuOpen: Boolean = false
    var menu: Menu? = null
    var shouldShowOtherMenu: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<View>(R.id.textView) as TextView
        //this view is associated with context menu
        //if you do a long click here, the context menu
        //will be displayed.
        registerForContextMenu(textView)
    }

    //
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        this.menu = menu;
        menuInflater.inflate(R.menu.game_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()

        if (shouldShowOtherMenu) {
            menuInflater.inflate(R.menu.context_menu, menu)
        } else {
            menuInflater.inflate(R.menu.game_menu, menu)
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onMenuOpened(featureId: Int, menu: Menu): Boolean {
        if (shouldKeepMenuOpen) {
            // If the flag is set, reopen the menu.
            window.openPanel(Window.FEATURE_OPTIONS_PANEL, null)
            shouldKeepMenuOpen = false // Reset the flag
        }
        return super.onMenuOpened(featureId, menu)
    }

    //
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.start -> {
                shouldShowOtherMenu = !shouldShowOtherMenu // Toggle the flag
                shouldKeepMenuOpen = true
                invalidateOptionsMenu()
                Toast.makeText(this, "You selected start!", Toast.LENGTH_LONG).show()
            }
            R.id.play -> Toast.makeText(this, "You selected Play!", Toast.LENGTH_LONG).show()
            R.id.playWell -> Toast.makeText(this, "You selected Play Well!", Toast.LENGTH_LONG)
                .show()
            R.id.stop -> Toast.makeText(this, "You selected stop!", Toast.LENGTH_SHORT).show()
            R.id.help -> Toast.makeText(this, "You selected help!", Toast.LENGTH_LONG).show()
            R.id.nothelp -> Toast.makeText(this, "You selected nothelp!", Toast.LENGTH_LONG).show()
            R.id.someId -> Toast.makeText(this, "You selected someID!", Toast.LENGTH_LONG).show()
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    override fun onOptionsMenuClosed(menu: Menu?) {

        if (!shouldKeepMenuOpen) {
            // Reopen the options menu if the flag is set
            super.onOptionsMenuClosed(menu)
        }
    }
    //
    override fun onCreateContextMenu(
        menu: ContextMenu?, v: View?,
        menuInfo: ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    //
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterContextMenuInfo?
        return when (item.itemId) {
            R.id.edit -> {
                Toast.makeText(this, "You selected Edit!", Toast.LENGTH_LONG).show()
                true
            }
            R.id.delete -> {
                Toast.makeText(this, "You selected Delete!", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
