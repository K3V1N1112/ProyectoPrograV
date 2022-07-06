package com.example.proyectoprograv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener() {
            register()
        }

        val btnBack: ImageButton = findViewById(R.id.imgBtnBack)
        btnBack.setOnClickListener{
            val intent: Intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun register(){
        val txtUser = findViewById<EditText>(R.id.txtUser).text
        Toast.makeText(this@RegistroActivity, "Bienvenido " + txtUser, Toast.LENGTH_SHORT).show()
    }
}

//prueba de funcionamiento Esteban