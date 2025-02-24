package com.csit284.vetalityshop

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val edit = findViewById<ImageButton>(R.id.edit)
        val settings = findViewById<ImageButton>(R.id.settings)
        val cart = findViewById<ImageButton>(R.id.cart)
        val home = findViewById<ImageButton>(R.id.home)
        val favourites = findViewById<ImageButton>(R.id.favourites)
        val list = findViewById<ImageButton>(R.id.list)
        val profile = findViewById<ImageButton>(R.id.profile)
        var intent : Intent

        settings.setOnClickListener{
            intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        home.setOnClickListener{
            intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showLogoutConfirmationDialog(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { dialog, id ->
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }
        builder.create().show()
    }
}