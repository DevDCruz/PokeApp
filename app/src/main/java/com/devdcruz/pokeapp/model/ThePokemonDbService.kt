package com.devdcruz.pokeapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ThePokemonDbService {

    @GET("popular")
    fun lisPopularMovies(@Query("api_key") apiKey: String) : Call<PokemonDbResult>
}