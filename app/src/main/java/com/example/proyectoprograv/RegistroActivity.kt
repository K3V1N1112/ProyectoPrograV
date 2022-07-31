package com.example.proyectoprograv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnBack: ImageButton = findViewById(R.id.imgBtnBack)
        btnBack.setOnClickListener{
            val intent: Intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }

        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener() {
            regitro()
            val intent: Intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
    }

    public fun regitro() {
        val txtUsuario = findViewById<EditText>(R.id.txtUser).text
        val txtCorreo = findViewById<EditText>(R.id.txtEmail).text
        val txtContrasena = findViewById<EditText>(R.id.txtPass).text
        val bd = openOrCreateDatabase("usuarios", MODE_PRIVATE, null)
        bd.execSQL("insert into usuarios(usuario, correo, contrasena) values('$txtUsuario', '$txtCorreo', '$txtContrasena')")
        Toast.makeText(this@RegistroActivity, "Registrado con Éxito", Toast.LENGTH_LONG).show()
        findViewById<EditText>(R.id.txtUser).setText("")
        findViewById<EditText>(R.id.txtEmail).setText("")
        findViewById<EditText>(R.id.txtPass).setText("")
        findViewById<EditText>(R.id.txtConfirmPass).setText("")
    }
}