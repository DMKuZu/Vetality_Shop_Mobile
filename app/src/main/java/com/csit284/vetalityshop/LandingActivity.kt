package com.csit284.vetalityshop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback

class LandingActivity : ComponentActivity() {
    private var backPressedOnce = false
    private val backPressHandler = Handler(Looper.getMainLooper())
    private val backPressRunnable = Runnable { backPressedOnce = false }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val home = findViewById<ImageButton>(R.id.home)
        val favourites = findViewById<ImageButton>(R.id.favourites)
        val list = findViewById<ImageButton>(R.id.list)
        val profile = findViewById<ImageButton>(R.id.profile)
        var intent : Intent

        home.setOnClickListener{
            intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // exits the app when back button is pressed twice in a row
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (backPressedOnce) {
                    finishAffinity()
                } else {
                    backPressedOnce = true
                    Toast.makeText(this@LandingActivity, "Press again to exit", Toast.LENGTH_SHORT).show()
                    backPressHandler.postDelayed(backPressRunnable, 2000)
                }
            }
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        backPressHandler.removeCallbacks(backPressRunnable)
    }

}