package com.devdcruz.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.devdcruz.pokeapp.databinding.ActivityMainBinding
import com.devdcruz.pokeapp.model.PokemonDbClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokeAdapter = PokeAdapter(emptyList()) { pokemon ->
            Toast
                .makeText(this@MainActivity, pokemon.title, Toast.LENGTH_LONG).show()
        }
        binding.recyclerV.adapter = pokeAdapter

        thread {
            val apikey = getString(R.string.api_key)
            val popularMovies = PokemonDbClient.service.lisPopularMovies(apikey)
            val body = popularMovies.execute().body()
            runOnUiThread{
                if (body!= null)
                    pokeAdapter.pokemonList = body.results
                    pokeAdapter.notifyDataSetChanged()
            }
        }
    }
}