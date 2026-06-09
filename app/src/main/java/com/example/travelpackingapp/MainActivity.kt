package com.example.travelpackingapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val quantityText = findViewById<EditText>(R.id.quantityEditText)

        addButton.setOnClcikListener {
            

        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}