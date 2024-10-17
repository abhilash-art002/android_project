package com.example.rosai

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge

class Location : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Enables edge-to-edge display (optional)
        setContentView(R.layout.activity_location)

        // Location list to display in the dropdown
        val locationList = arrayOf("Bhubaneswar", "Cuttack", "Dhenkanal", "Puri", "Sambalpur")

        // Create an ArrayAdapter to populate the dropdown list
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, locationList)

        // Get reference to AutoCompleteTextView and set the adapter
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteLocation)
        autoCompleteTextView.setAdapter(adapter)

        // Get reference to the ImageView (dropdown arrow icon)
        val dropdownArrow = findViewById<ImageView>(R.id.arrow_down)

        // When the user clicks the arrow, show the dropdown
        dropdownArrow.setOnClickListener {
            autoCompleteTextView.showDropDown() // Show the dropdown programmatically
        }

        // Handle what happens when a user selects an option
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedLocation = parent.getItemAtPosition(position).toString()

            // Display a toast message or perform any action with the selected location
            Toast.makeText(this, "Selected Location: $selectedLocation", Toast.LENGTH_SHORT).show()
        }
    }
}
