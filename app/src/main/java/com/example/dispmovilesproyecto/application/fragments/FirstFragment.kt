package com.example.dispmovilesproyecto.application.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.dispmovilesproyecto.application.login.usercases.SaveUserUC
import com.example.dispmovilesproyecto.data.remote.dto.UserDtoRemote
import com.example.dispmovilesproyecto.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import com.example.dispmovilesproyecto.application.viewmodel.FirstViewModel
import kotlinx.coroutines.flow.collect

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding
    lateinit var db : FirebaseFirestore

    private val firstVM by viewModels<FirstViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVariables()
        initListeners()
        initObservers()

    }

    private fun initListeners() {
        binding.btnRegresar.setOnClickListener{
            //Primera forma
            //findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            //Segunda forma con safeargs
            //FirstFragmentDirections.actionFirstFragmentToSecondFragment(0, "aasdfg")

            val user = UserDtoRemote(
                "",
                binding.nameUser.text.toString(),
                binding.lastnameUser.text.toString()
            )


            lifecycleScope.launch (Dispatchers.Main ){
                firstVM.contador()

            }

            lifecycleScope.launch(Dispatchers.Main) {
                firstVM.guardarUsuario(user, db, SaveUserUC())

            }

//            lifecycleScope.launch(Dispatchers.Main){
//
//                val usnew = withContext(Dispatchers.IO){
//                    saveUser(user)
//                }
//                if(usnew.getOrNull() != null){
//                    Snackbar.make(binding.nameUser,
//                        "Usuario guardado correctamente",
//                        Snackbar.LENGTH_LONG)
//                        .show()
//                }
//            }

        }
    }

    private fun initObservers(){
        firstVM.counterUI.observe(viewLifecycleOwner){
            binding.contadorTxt.text = it.toString()
        }

        firstVM.userRemote.observe(viewLifecycleOwner){
            Snackbar.make(
                binding.nameUser,
                it.name + " registrado correctamente",
                Snackbar.LENGTH_LONG)
                .show()
        }
    }


    private fun initVariables(){
        db = Firebase.firestore
    }

}