package com.example.proyectoprograv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val btnVersion = findViewById<Button>(R.id.btnVersion)
        btnVersion.setOnClickListener{
            version()
        }
    }

    public fun version() {
        val txtVersion = findViewById<EditText>(R.id.txtVersion).text
        val bd = openOrCreateDatabase("version", MODE_PRIVATE, null)
        //bd.execSQL("insert into version(ver) values('$txtVersion')")
        bd.execSQL("update version set ver = $txtVersion where _id like '1'")
        Toast.makeText(this@SettingsActivity, "Version cambiada con éxito", Toast.LENGTH_LONG).show()
        findViewById<EditText>(R.id.txtVersion).setText("")
    }
}