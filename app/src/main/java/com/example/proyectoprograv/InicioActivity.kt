package com.example.proyectoprograv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        BaseDatos()

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            val intent: Intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener{
            val intent: Intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        val btnInvite: Button = findViewById(R.id.btnInvite)
        btnInvite.setOnClickListener{
            val intent: Intent = Intent(this, ExploreActivity::class.java)
            startActivity(intent)
        }

        val btnSalir: Button = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener{
            System.exit(0)
        }
    }

    protected fun BaseDatos() {
        val bd = openOrCreateDatabase("usuarios", MODE_PRIVATE, null)
        bd.execSQL("create table if not exists usuarios(_id integer primary key autoincrement, usuario TEXT NOT NULL, correo TEXT NOT NULL, contrasena TEXT NOT NULL )")
    }
}