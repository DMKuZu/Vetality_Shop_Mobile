package com.csit284.vetalityshop

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class EditProfileActivity : Activity() {
    private lateinit var editName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val back = findViewById<ImageButton>(R.id.back)
        val editUsernameButton = findViewById<Button>(R.id.edit_username_btn)
        editName = findViewById(R.id.edit_username)

        back.setOnClickListener {
            finish()
        }

        editUsernameButton.setOnClickListener {
            val updatedName = editName.text

            if(updatedName.isNullOrEmpty()){
                Toast.makeText(this, "Input a Username!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultIntent = Intent()
            resultIntent.putExtra("updatedName", updatedName.toString().trim())
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

}