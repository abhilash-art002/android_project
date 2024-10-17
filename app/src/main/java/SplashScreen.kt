package com.example.rosai

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setting the correct layout file for the splash screen
        setContentView(R.layout.splasscreen)

        // Using the non-deprecated Handler constructor
        Handler(Looper.getMainLooper()).postDelayed({
            // Navigating to the StartActivity after a 7-second delay
            val intent = Intent(this@SplashScreen, StartActivity::class.java)
            startActivity(intent)
            finish() // Close the SplashScreen activity
        }, 2000) // 7 seconds delay
    }
}
