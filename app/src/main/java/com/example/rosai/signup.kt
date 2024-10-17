package com.example.rosai

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class signup : AppCompatActivity() {
    lateinit var haveaccount: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        haveaccount= findViewById(R.id.haveaccount)

        haveaccount.setOnClickListener {
            val intent = Intent(this@signup, MainActivity::class.java)
            startActivity(intent)
        }
    }
}