package com.example.rosai

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.rosai.com.example.rosai.database.DatabaseHelper
import com.example.rosai.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {

    private lateinit var haveAccount: TextView
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var databaseHelper: DatabaseHelper
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        haveAccount = findViewById(R.id.haveaccount)
        haveAccount.setOnClickListener {
            val intent = Intent(this@Login, signup::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener {
            email = binding.editTextTextEmailAddress.text.toString().trim()
            password = binding.editTextTextPassword.text.toString().trim()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please Fill All The Details", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(email, password)
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        val user = databaseHelper.getUserByEmail(email)
        if (user != null && user.password == password) {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
            updateUI()
        } else {
            Toast.makeText(this, "Authentication failed. Please check your credentials.", Toast.LENGTH_SHORT).show()
            Log.d("Login", "loginUser: Authentication Failure")
        }
    }

    private fun updateUI() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
