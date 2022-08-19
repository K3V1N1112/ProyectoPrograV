package com.example.proyectoprograv

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    override fun onResume() {
        super.onResume()
        val bd = openOrCreateDatabase("version", MODE_PRIVATE, null)
        val numVer = bd.rawQuery("select ver from version where _id like '1'", null)
        numVer.moveToFirst()
        val version = numVer.getString(0)
        findViewById<TextView>(R.id.lblVersion).setText(version)
        numVer.close()
    }
}