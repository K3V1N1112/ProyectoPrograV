package com.example.proyectoprograv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            val dialogo1 = AlertDialog.Builder(this)
            dialogo1.setTitle("Registrarse")
            dialogo1.setMessage("¿Desea registrarse con la informacion anterior?")
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
        registro()
    }

    private fun no() {
        Toast.makeText(this, "No se registró, intente nuevamente", Toast.LENGTH_SHORT).show()
    }

    fun registro(){
        val txtUsuario = findViewById<EditText>(R.id.txtUser).text
        val txtCorreo = findViewById<EditText>(R.id.txtEmail).text
        val txtContrasena = findViewById<EditText>(R.id.txtPass).text
        val txtReContrasena = findViewById<EditText>(R.id.txtConfirmPass).text

        if(txtUsuario.isNotEmpty() && txtCorreo.isNotEmpty()  && txtContrasena.isNotEmpty() && txtReContrasena.isNotEmpty()){
            val bd = openOrCreateDatabase("usuarios", MODE_PRIVATE, null)
            bd.execSQL("insert into usuarios(usuario, correo, contrasena) values('$txtUsuario', '$txtCorreo', '$txtContrasena')")
            Toast.makeText(this@RegistroActivity, "Registrado con Éxito", Toast.LENGTH_LONG).show()
            findViewById<EditText>(R.id.txtUser).setText("")
            findViewById<EditText>(R.id.txtEmail).setText("")
            findViewById<EditText>(R.id.txtPass).setText("")
            findViewById<EditText>(R.id.txtConfirmPass).setText("")
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
        }else{
            Error()
        }
    }

    fun Error(){
        Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
    }
}