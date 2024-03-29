package com.example.proyectoprograv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class PlaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)

        val btnBack: ImageButton = findViewById(R.id.imgBtnBack)
        btnBack.setOnClickListener{
            val intent: Intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }

        val btnDescubre: Button = findViewById(R.id.btnDescubre)
        btnDescubre.setOnClickListener{
            val intent: Intent = Intent(this, InfoPlaceActivity::class.java)
            startActivity(intent)
        }
    }
}