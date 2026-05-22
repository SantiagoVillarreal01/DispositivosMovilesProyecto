package com.example.dispmovilesproyecto

import android.app.SearchManager
import com.example.dispmovilesproyecto.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dispmovilesproyecto.adapters.CustomAdapter
import com.example.dispmovilesproyecto.databinding.ActivityPrincipalBinding
import com.example.dispmovilesproyecto.dto.Empresas
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout

class Principal : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityPrincipalBinding
    var adapterRecyclerView = CustomAdapter (
        {getName(it)},
        {deleteEmpresas(it)})

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initVariables()
        initListeners()


    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun initVariables(){

        intent.extras.let {
            var saludo = it?.getString("xx1")

            Snackbar.make(binding.urlTxt,
                saludo.toString(),
                Snackbar.LENGTH_LONG
            ).show()
        }
        var options = listOf<String>("Youtube", "Google", "Facebook", "Apple","Youtube", "Google", "Facebook", "Apple")
//        var myAdapter = ArrayAdapter(this, R.layout.my_spinner_layout, options)
//        //Funciones de ambiente
//        binding.spinnerURLs.apply {
//            adapter = myAdapter
//            onItemSelectedListener = this@Principal
//        }

        //RecyclerView

        var optionsEmpresas = listOf<Empresas>(
            Empresas(
                "Youtube",
                "https://th.bing.com/th/id/OIP.ADch_tPEdON9hjdv8CTSMgHaHa?w=188&h=188&c=7&r=0&o=7&dpr=1.3&pid=1.7&rm=3",
                 "https://www.youtube.com/"),

            Empresas("Google",
                "https://th.bing.com/th/id/OIP.HgH-NjiOdFOrkmwjsZCCfAHaHl?w=175&h=180&c=7&r=0&o=7&dpr=1.3&pid=1.7&rm=3",
                  "https://google.com.ec"),

            Empresas("Facebook",
                "https://tse1.mm.bing.net/th/id/OIP.MGVIQoCWN9vkAxpirYyU_AHaHY?r=0&pid=ImgDet&w=187&h=185&c=7&dpr=1,3&o=7&rm=3",
                  "https://facebook.com"),

            Empresas("Apple",
                "https://tse2.mm.bing.net/th/id/OIP.jsEk2cgt21FCWAyrUVe7MwHaHa?r=0&pid=ImgDet&w=184&h=184&c=7&dpr=1,3&o=7&rm=3",
                "https://apple.com")
        )

        //var adapterRecyclerView = CustomAdapter(optionsEmpresas) {getName(it)}

        binding.RvURLs.adapter = adapterRecyclerView
//        binding.RvURLs.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.HORIZONTAL,
//            false
//        )
        binding.RvURLs.layoutManager = GridLayoutManager(this,2)

//        adapterRecyclerView.lista = optionsEmpresas as MutableList<Empresas>
//        adapterRecyclerView.notifyDataSetChanged()

        adapterRecyclerView.submitList(optionsEmpresas)

    }


    fun getName(emp : Empresas){
//        val intent = Intent(Intent.ACTION_VIEW)
//        intent.setData(Uri.parse(emp.url))
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, emp.name)
        startActivity(intent)
    }

    fun deleteEmpresas(emp : Empresas){
//        var newEmpresas = adapterRecyclerView.lista.minus(emp)
//        adapterRecyclerView.lista = newEmpresas as MutableList<Empresas>
//        adapterRecyclerView.notifyDataSetChanged()

        val currentList = adapterRecyclerView.currentList.toMutableList()
        currentList.remove(emp)
        adapterRecyclerView.submitList(currentList)
    }



    private fun initListeners(){
        binding.urlBtn.setOnClickListener{
            val url = binding.urlTxt.text.toString()

            //Abrir url
            //val i = Intent(Intent.ACTION_VIEW)
            //i.setData(Uri.parse(url))
            //startActivity(i)

            //Abrir un mapa
            val mapIntent = Intent(Intent.ACTION_VIEW)
            val gmmIntentUri = Uri.parse("geo:-0.20132619437205682, -78.50729833397087")
            mapIntent.setData(gmmIntentUri)

            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.mn_home -> {
                    Snackbar.make(binding.RvURLs, item.title.toString(), Snackbar.LENGTH_LONG).show()
                    true
                }
                R.id.mn_pag1 -> {
                    Toast.makeText(this, "Pagina 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.mn_pag2 -> {
                    val dialog =  MaterialAlertDialogBuilder(this)
                        .setTitle("Cerrar Sesion")
                        .setMessage("¿Esta usted seguro de salir de la aplicacion?")
                        .setCancelable(true)
                        .setPositiveButton("Si") { dialog, id ->
                            val intent = Intent(this, Login3::class.java)
                            startActivity(intent)
                        }
                        .setNegativeButton("No"){
                                dialog, id -> dialog.cancel()
                        }
                        .setNeutralButton("Cancelar"){
                                dialog, id -> dialog.dismiss()
                        }
                        .show()
                    true
                }
                else -> false
            }
        }

    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long) {
        Toast.makeText(
            this,
            "Posicion seleccionada es ${position}",
            Toast.LENGTH_LONG)
        .show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}