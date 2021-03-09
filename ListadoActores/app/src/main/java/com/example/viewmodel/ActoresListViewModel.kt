package com.example.listadoactores.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelcampos.listadoelementos.poko.Pokemon
import com.miguelcampos.listadoelementos.poko.PokemonAllResponse
import com.miguelcampos.listadoelementos.retrofit.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP

 private val _actores = MutableLiveData<List<Actores>>()
    private val baseUrl = "https://api.themoviedb.org/3/person"
    private lateinit var service: ActoresService


    val actores: LiveData<List<Actores>>
        get() = _actores

    init {
        _actores.value = listOf()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ActoresService::class.java)
        getActoresList()
    }

    fun getActoresList() {
        service.listadoActores().enqueue(object: Callback<ActoresResponse> {
            override fun onResponse(
                call: Call<ActoresResponse>,
                response: Response<ActoresResponse>
            ) {
                if(response.code() == 200) {
                    _actores.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<ActoresResponse>, t: Throwable) {
                // Entra cuando falla la comunicación con el servidor
            }
        })
    }