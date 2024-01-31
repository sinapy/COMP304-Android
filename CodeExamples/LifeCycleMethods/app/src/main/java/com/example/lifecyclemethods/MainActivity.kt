package com.example.lifecyclemethods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    var TAG:String = "Activity LifeCycle Methods Demo: "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() method executed !! ");
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() method executed !! ");
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() method executed !! ");
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() method executed !! ");
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() method executed !! ");
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() method executed !! ")
    }
}