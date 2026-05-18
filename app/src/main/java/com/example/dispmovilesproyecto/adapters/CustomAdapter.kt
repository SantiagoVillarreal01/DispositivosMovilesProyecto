package com.example.dispmovilesproyecto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dispmovilesproyecto.R
import com.example.dispmovilesproyecto.databinding.MySpinnerLayoutBinding
import com.example.dispmovilesproyecto.dto.Empresas
import com.squareup.picasso.Picasso


class CustomAdapter(var lista: List<Empresas>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    class CustomViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private var localBinding : MySpinnerLayoutBinding = MySpinnerLayoutBinding.bind(view)

        fun render(item: Empresas) {
            localBinding.txtEmpresa.setText(item.name)
            Picasso.get().load(item.image).into(localBinding.imgEmpresa)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var inflate = LayoutInflater.from(parent.context)
        return CustomViewHolder(inflate.inflate(
            R.layout.my_spinner_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.render(lista[position])
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}