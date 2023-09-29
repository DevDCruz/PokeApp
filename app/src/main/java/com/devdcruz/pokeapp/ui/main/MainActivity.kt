package com.devdcruz.pokeapp.ui.main

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.devdcruz.pokeapp.R
import com.devdcruz.pokeapp.databinding.ActivityMainBinding
import com.devdcruz.pokeapp.model.Movie
import com.devdcruz.pokeapp.model.MovieDbClient
import com.devdcruz.pokeapp.ui.detail.DetailActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val requestPermissionLaunger = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        isGrantred ->
        val message = if (isGrantred) "Permission granted" else "Permission Rejected"
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieAdapter = MovieAdapter(emptyList()) { navigateTo(it) }
        binding.recyclerV.adapter = movieAdapter

        requestPermissionLaunger.launch(Manifest.permission.ACCESS_COARSE_LOCATION)

        lifecycleScope.launch {
            val apikey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.lisPopularMovies(apikey)
            movieAdapter.movieList = popularMovies.results
            movieAdapter.notifyDataSetChanged()
        }

    }

    private fun navigateTo(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
        startActivity(intent)
    }
}