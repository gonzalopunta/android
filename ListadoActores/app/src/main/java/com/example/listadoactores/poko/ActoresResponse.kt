package com.example.listadoactores.poko

data class ActoresResponse(
    val page: Int,
    val results: List<Actores>,
    val total_pages: Int,
    val total_results: Int
)