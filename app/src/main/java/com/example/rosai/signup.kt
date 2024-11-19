package com.example.rosai

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.rosai.com.example.rosai.database.DatabaseHelper
import com.example.rosai.com.example.rosai.model.UserModel
import com.example.rosai.databinding.ActivitySignupBinding

class signup : AppCompatActivity() {

    private lateinit var haveaccount: TextView
    private lateinit var userName: String
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var databaseHelper: DatabaseHelper

    private val binding: ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Initialize SQLite DatabaseHelper
        databaseHelper = DatabaseHelper(this)

        binding.createAccountbutton.setOnClickListener {
            userName = binding.editTextTextName.text.toString()
            email = binding.editTextTextEmailAddress.text.toString().trim()
            password = binding.editTextTextPassword.text.toString().trim()

            if (userName.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please Fill All The Details", Toast.LENGTH_SHORT).show()
            } else {
                createAccount()
            }
        }

        haveaccount = findViewById(R.id.haveaccount)
        haveaccount.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createAccount() {
        val user = UserModel(userName, email, password)
        val result = databaseHelper.addUser(user)
        if (result != -1L) {
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@signup, Login::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Account Creation Failed", Toast.LENGTH_SHORT).show()
            Log.d("Account", "createAccount: Failure")
        }
    }
}
