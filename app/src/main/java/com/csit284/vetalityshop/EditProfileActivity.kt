package com.csit284.vetalityshop

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton

class EditProfileActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val back = findViewById<ImageButton>(R.id.back)

        back.setOnClickListener {
            finish()
        }
    }
}