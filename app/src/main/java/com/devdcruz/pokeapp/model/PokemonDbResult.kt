package com.devdcruz.pokeapp.model

data class PokemonDbResult(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)