package com.csit284.vetalityshop

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogoutActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        showLogoutConfirmationDialog()
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