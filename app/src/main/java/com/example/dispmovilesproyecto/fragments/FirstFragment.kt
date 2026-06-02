package com.example.dispmovilesproyecto.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dispmovilesproyecto.R
import com.example.dispmovilesproyecto.databinding.FragmentFirstBinding
import androidx.navigation.fragment.findNavController

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()
    }

    private fun initListeners() {
        binding.btnRegresar.setOnClickListener{
            //Primera forma
            //findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            //Segunda forma con safeargs
            FirstFragmentDirections.actionFirstFragmentToSecondFragment(0, "aasdfg")

        }
    }

}