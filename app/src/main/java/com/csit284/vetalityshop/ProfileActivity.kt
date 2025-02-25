package com.csit284.vetalityshop

import android.graphics.drawable.BitmapDrawable
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class ProfileActivity : Activity() {
//    private lateinit var defaultProfile: Bitmap
    private lateinit var defaultName: String
    private val REQUEST_CODE_EDIT_PROFILE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val edit = findViewById<ImageButton>(R.id.edit)
//        val profilepic = findViewById<ImageView>(R.id.defaultprofile)
        val username = findViewById<TextView>(R.id.defaultname)

        val settings = findViewById<ImageButton>(R.id.settings)
        val logout = findViewById<ImageButton>(R.id.logout)
        val cart = findViewById<ImageButton>(R.id.cart)
        val home = findViewById<ImageButton>(R.id.home)
        val favourites = findViewById<ImageButton>(R.id.favourites)
        val list = findViewById<ImageButton>(R.id.list)
        val profile = findViewById<ImageButton>(R.id.profile)
        var intent : Intent

//        defaultProfile = (profilepic.drawable as BitmapDrawable).bitmap
        defaultName = username.text.toString()

        edit.setOnClickListener {
            intent = Intent(this, EditProfileActivity::class.java)
//            intent.putExtra("defaultProfile", defaultProfile)
            intent.putExtra("defaultName", defaultName)
            startActivityForResult(intent, REQUEST_CODE_EDIT_PROFILE)
        }

        settings.setOnClickListener{
            intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        logout.setOnClickListener{
            showLogoutConfirmationDialog()
        }

        home.setOnClickListener{
            intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_EDIT_PROFILE && resultCode == Activity.RESULT_OK) {
            data?.extras?.let  {
//                val updatedProfile = it.getParcelable("updatedProfile",Bitmap::class.java)
                val updatedName = it.getString("updatedName")

                // Update the ImageView and TextView with the new values
//                findViewById<ImageView>(R.id.defaultprofile).setImageBitmap(updatedProfile)
                findViewById<TextView>(R.id.defaultname).text = updatedName
            }
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