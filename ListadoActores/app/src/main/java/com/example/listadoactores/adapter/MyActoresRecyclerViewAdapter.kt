package com.example.listadoactores.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load

class MyActoresRecyclerViewAdapter(
    private var values: List<Actores>
) : RecyclerView.Adapter<MyActoresRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_actores, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewValoracionMedia: TextView = view.findViewById(R.id.text_view_valoracion_media)
        val textViewNombre: TextView = view.findViewById(R.id.text_view_nombre)
        val imageViewPhoto: ImageView = view.findViewById(R.id.image_view_restaurant)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = values[position]
        val id = currentItem.url.reversed().split("/")[1].reversed()
        holder.textViewValoracionMedia.text = id
        holder.textViewNombre.text = currentItem.name.capitalize()
        holder.imageViewPhoto.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/actores/${id}.png")
    }

    fun setData(newActoress: List<Actores>) {
       this.values = newActoress
        // Refresca la IU para que se muestren los nuevos
        // Actores en la lista
        notifyDataSetChanged()
    }



}