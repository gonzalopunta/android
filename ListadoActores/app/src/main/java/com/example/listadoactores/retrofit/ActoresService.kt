package com.example.listadoactores.retrofit

import com.example.listadoactores.poko.ActoresResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ActoresService {

    @GET ("person/popular")
    fun listadoActores(): Call<List<ActoresResponse>>

    @GET("person/{id}")
    fun getDetailActor(@Query("id") id: Int)
}