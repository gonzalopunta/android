package com.example.listadoactores.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.listadoactores.R
import com.example.listadoactores.adapter.MyActoresRecyclerViewAdapter
import com.example.listadoactores.poko.Actores
import com.example.listadoactores.viewmodel.ActoresListViewModel

class PeopleListFragment : Fragment() {

    var listaActores: List<Actores> = listOf()
    lateinit var listaAdapter: MyActoresRecyclerViewAdapter
    lateinit var viewModel: ActoresListViewModel
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_actores_list, container, false)

        viewModel = ViewModelProvider(this).get(ActoresListViewModel::class.java)
        val v = view as RecyclerView

        listaAdapter = MyActoresRecyclerViewAdapter(listaPokemon)
        v.layoutManager = LinearLayoutManager(context)
        v.adapter = listaAdapter

        viewModel.actores.observe(viewLifecycleOwner, Observer {
            actores -> listaActores = actores
            listaAdapter.setData(actores.sortedWith(compareBy({ it.name })))
        })

        return view
    }
}