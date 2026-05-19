package com.example.dispmovilesproyecto.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dispmovilesproyecto.R
import com.example.dispmovilesproyecto.databinding.MySpinnerLayoutBinding
import com.example.dispmovilesproyecto.dto.Empresas
import com.squareup.picasso.Picasso


class CustomAdapter(
        //var lista: List<Empresas>,
        var onClick: (Empresas) -> Unit,
        var onDelete : (Empresas) -> Unit
    ) : ListAdapter<Empresas, CustomAdapter.CustomViewHolder>(EmpresasDiffCallback()) {


    //var lista: MutableList<Empresas> = ArrayList<Empresas>()

    class CustomViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        private var localBinding : MySpinnerLayoutBinding = MySpinnerLayoutBinding.bind(view)

        fun render(item: Empresas,
                   onClick: (Empresas) -> Unit,
                   onDelete: (Empresas) -> Unit) {
            localBinding.txtEmpresa.text = item.name
            Picasso.get().load(item.image).into(localBinding.imgEmpresa)
            localBinding.imgEmpresa.setOnClickListener{
                onClick(item)
            }
            localBinding.txtEmpresa.setOnClickListener{
                onDelete(item)
            }
        }
    }

    class EmpresasDiffCallback : DiffUtil.ItemCallback<Empresas>() {

        override fun areItemsTheSame(oldItem: Empresas, newItem: Empresas): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Empresas, newItem: Empresas): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        var inflate = LayoutInflater.from(parent.context)
        return CustomViewHolder(inflate.inflate(
            R.layout.my_spinner_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val empresa = getItem(position)
        holder.render(empresa, onClick, onDelete)
    }



}