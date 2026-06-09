package com.example.travelpackingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val itemNames = mutableListOf<String>()
    val itemQuantity =  mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.addButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val exitButton = findViewById<Button>(R.id.exitButton)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val quantityEditText = findViewById<EditText>(R.id.quantityEditText)

        addButton.setOnClickListener {
            nameEditText.visibility = android.view.View.VISIBLE
            quantityEditText.visibility = android.view.View.VISIBLE
        }

        saveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val quantity = quantityEditText.text.toString().toInt()

            itemNames.add(name)
            itemQuantity.add(quantity)

            nameEditText.text.clear()
            quantityEditText.text.clear()
        }

        nextButton.setOnClickListener {
            val intent = Intent(this, DisplayScreen::class.java)
            intent.putExtra("itemNames", ArrayList(itemNames))
            intent.putExtra("itemQuantity",ArrayList(itemQuantity))
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finish()
        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}