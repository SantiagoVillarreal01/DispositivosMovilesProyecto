package com.example.dispmovilesproyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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
                var intent = Intent(this, Principal::class.java)
                startActivity(intent)

            }
            else
                Toast.makeText(
                    this,
                    msg,
                    Toast.LENGTH_SHORT
                ).show()
        }
    }

}