package com.csit284.vetalityshop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SettingsActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val back = findViewById<ImageButton>(R.id.back)
        val devpage = findViewById<Button>(R.id.devpage)
        var intent: Intent

        back.setOnClickListener {
            finish()
        }

        devpage.setOnClickListener {
            intent = Intent(this, DeveloperActivity::class.java)
            startActivity(intent)
        }
    }


}