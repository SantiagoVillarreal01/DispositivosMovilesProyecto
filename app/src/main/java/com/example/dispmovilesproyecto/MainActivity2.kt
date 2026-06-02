package com.example.dispmovilesproyecto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.dispmovilesproyecto.databinding.ActivityMain2Binding
import com.example.dispmovilesproyecto.fragments.FirstFragment
import com.example.dispmovilesproyecto.fragments.SecondFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mn_home -> {

                    supportFragmentManager.commit{
                        val f1 = FirstFragment()
                        replace(R.id.fragmentViewer, f1)
                        // addToBackStack(null)

                    }
                    true
                }

                R.id.mn_pag1 -> {
                    supportFragmentManager.commit{
                        val f1 = SecondFragment()
                        replace(R.id.fragmentViewer, f1)
                        // addToBackStack(null)

                    }
                    true
                }

                R.id.mn_pag2 -> {
                    val dialog = MaterialAlertDialogBuilder(this)
                        .setTitle("Cerrar Sesion")
                        .setMessage("¿Esta usted seguro de salir de la aplicacion?")
                        .setCancelable(true)
                        .setPositiveButton("Si") { dialog, id ->
                            val intent = Intent(this, Login3::class.java)
                            startActivity(intent)
                        }
                        .setNegativeButton("No") { dialog, id ->
                            dialog.cancel()
                        }
                        .setNeutralButton("Cancelar") { dialog, id ->
                            dialog.dismiss()
                        }
                        .show()
                    true
                }

                else -> false
            }

        }
    }
}