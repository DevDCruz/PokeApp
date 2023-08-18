package com.devdcruz.pokeapp.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/movie/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(ThePokemonDbService::class.java)

}