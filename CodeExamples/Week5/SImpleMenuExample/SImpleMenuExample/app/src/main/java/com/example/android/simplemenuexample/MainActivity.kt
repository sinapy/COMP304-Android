package com.example.android.simplemenuexample
//
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//
class MainActivity : AppCompatActivity() {
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
        val inflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)
        return true
    }

    //
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.getItemId()) {
            R.id.start -> Toast.makeText(this, "You selected start!", Toast.LENGTH_LONG).show()
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
        val info = item.getMenuInfo() as AdapterContextMenuInfo
        return when (item.getItemId()) {
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
