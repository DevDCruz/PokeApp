package com.devdcruz.pokeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.devdcruz.pokeapp.databinding.ActivityMainBinding
import com.devdcruz.pokeapp.model.Pokemon
import com.devdcruz.pokeapp.model.PokemonDbClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokeAdapter = PokeAdapter(emptyList()) { navigateTo(it) }
        binding.recyclerV.adapter = pokeAdapter

        lifecycleScope.launch {
            val apikey = getString(R.string.api_key)
            val popularMovies = PokemonDbClient.service.lisPopularMovies(apikey)
            pokeAdapter.pokemonList = popularMovies.results
            pokeAdapter.notifyDataSetChanged()
        }

    }

    private fun navigateTo(pokemon: Pokemon) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_POKEMON, pokemon)
        startActivity(intent)
    }
}