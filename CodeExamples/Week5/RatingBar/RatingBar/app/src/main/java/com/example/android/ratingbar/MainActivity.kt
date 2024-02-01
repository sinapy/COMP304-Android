package com.example.android.ratingbar

import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var ratingBar: RatingBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        ratingBar = findViewById<View>(R.id.ratingBar) as RatingBar
        ratingBar!!.onRatingBarChangeListener =
            OnRatingBarChangeListener { ratingBar, rating, fromTouch ->
                (findViewById<View>(R.id.textView) as TextView).text = "Rating: $rating"
            }

    }

    fun rateService(v: View?) {
        val rating = ratingBar!!.rating.toString()
        Toast.makeText(applicationContext, rating, Toast.LENGTH_LONG).show()
    }


}