package com.example.dispmovilesproyecto.application.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dispmovilesproyecto.databinding.ActivityLogin3Binding

class Login3 : AppCompatActivity() {

    lateinit var binding: ActivityLogin3Binding
    var counter: Int = 0

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{

            var msg = ""
            if (binding.txtUsername.text.toString() == "admin"
                && binding.txtPassword.text.toString() == "admin")
                msg = "Usuario autenticado correcta"
            else
                msg = "Usuario/password incorrecto"
            Toast.makeText(
                this,
                "Hola Mundo",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables()
        initListeners()
    }

    private fun initVariables() {
        counter = 1
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener{

            var msg = ""
            if (binding.txtUsername.text.toString() == "admin"
                && binding.txtPassword.text.toString() == "admin") {
                var intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("xx1", "Bienvenido de nuevo")
                startActivity(intent)

            }
            else
                Toast.makeText(
                    this,
                    "Nombre de usuario/Contraseña incorrecto",
                    Toast.LENGTH_SHORT
                ).show()
        }
    }

}