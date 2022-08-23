package com.example.proyectoprograv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener{
            val txtUser = findViewById<EditText>(R.id.txtUser).text.toString()
            val txtPass = findViewById<EditText>(R.id.txtPass).text.toString()

            if (txtUser == "" || txtPass == "") {
                Toast.makeText(this@LoginActivity, "Llene todos los campos vacios", Toast.LENGTH_LONG).show()
            } else {
                val result: Boolean = validarCuenta(txtUser, txtPass)
                if (result) {
                    login()
                } else {
                    Toast.makeText(this@LoginActivity, "Datos incorrectos", Toast.LENGTH_LONG).show()
                }
            }
        }

        val btnBack: ImageButton = findViewById(R.id.imgBtnBack)
        btnBack.setOnClickListener{
            val intent: Intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }
    }

    private fun login(){
        val txtUser = findViewById<EditText>(R.id.txtUser).text
        val usuario = Intent(this, ExploreActivity::class.java)
        startActivity(usuario)
        Toast.makeText(this@LoginActivity, "Bienvenido " + txtUser, Toast.LENGTH_SHORT).show()
    }

    fun validarCuenta(txtUser: String, txtPass: String): Boolean {
        val bd = openOrCreateDatabase("usuarios", MODE_PRIVATE, null)
        val cursor = bd.rawQuery(
            "select * from usuarios where usuario = ? and contrasena = ?",
            arrayOf(txtUser, txtPass)
        )
        return if (cursor.count > 0) {
            true
        } else {
            false
        }
    }
}