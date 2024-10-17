package com.example.rosai

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    lateinit var button5: Button
    lateinit var haveaccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        button5 = findViewById(R.id.button5)
        haveaccount= findViewById(R.id.haveaccount)

        button5.setOnClickListener {
            val intent = Intent(this@Login, signup::class.java)
            startActivity(intent)
        }

        haveaccount.setOnClickListener {
            val intent = Intent(this@Login, signup::class.java)
            startActivity(intent)
        }

    }
}