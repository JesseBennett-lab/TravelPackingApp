package com.example.travelpackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display_screen)

        val displayTextView = findViewById<TextView>(R.id.displayTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        val itemNames = intent.getStringArrayListExtra("itemNames") ?:emptyList()
        val itemQuantity = intent.getIntegerArrayListExtra("itemQuantity") ?:emptyList()

        var displayString = ""
        for (i in itemNames.indices) {
            val name = itemNames[i]
            val quantity = itemQuantity[i]
            if (quantity >= 2) {
                displayString += "$name - $quantity\n"
            }
            displayTextView.text = displayString
        }
        backButton.setOnClickListener {
            finish()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}