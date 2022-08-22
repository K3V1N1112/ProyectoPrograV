package com.example.proyectoprograv

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        val btnSettings: Button = findViewById(R.id.btnSettings)
        btnSettings.setOnClickListener{
            val intent: Intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val btnAbout: Button = findViewById(R.id.btnAbout)
        btnAbout.setOnClickListener{
            val intent: Intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

        val btnSalir = findViewById<View>(R.id.btnSalir) as Button
        btnSalir.setOnClickListener {
            val dialogo1 = AlertDialog.Builder(this)
            dialogo1.setTitle("Salir")
            dialogo1.setMessage("¿Realmente desea salir de la aplicación?")
            dialogo1.setCancelable(false)
            dialogo1.setNegativeButton(
                "No"
            ) { dialogo1, id -> no() }
            dialogo1.setPositiveButton(
                "Si"
            ) { dialogo1, id -> si() }
            dialogo1.show()
        }
    }

    private fun si() {
        System.exit(0)
    }

    private fun no() {
        Toast.makeText(this, "Se mantendrá en la aplicación", Toast.LENGTH_SHORT).show()
    }

    protected fun BaseDatos() {
        val bd = openOrCreateDatabase("usuarios", MODE_PRIVATE, null)
        bd.execSQL("create table if not exists usuarios(_id integer primary key autoincrement, usuario TEXT NOT NULL, correo TEXT NOT NULL, contrasena TEXT NOT NULL )")
        val bdVersion = openOrCreateDatabase("version", MODE_PRIVATE, null)
        bdVersion.execSQL("create table if not exists version(_id integer primary key autoincrement, ver TEXT NOT NULL)")
    }
}