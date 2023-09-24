package com.devdcruz.pokeapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.devdcruz.pokeapp.databinding.ActivityDetailBinding
import com.devdcruz.pokeapp.model.Pokemon

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_POKEMON = "DetailActivity:pokemon"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //i have to search an alternative for getParcelable beacuse is deprecatedA

        val pokemon = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_POKEMON, Pokemon::class.java)
        } else {
            intent.getParcelableExtra(EXTRA_POKEMON)
        }
        if (pokemon != null) {
            title = pokemon.title
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w780/${pokemon.backdrop_path}")
                .into(binding.backdrop)
            binding.summary.text = pokemon.overview
            bindDetailInfo(binding.detailInfo, pokemon)
        }
    }

    private fun bindDetailInfo(detailInfo: TextView, pokemon: Pokemon) {
        detailInfo.text = buildSpannedString {
            bold { append("Original language: ") }
            appendLine(pokemon.original_language)

            bold { append("Original title: ") }
            appendLine(pokemon.original_title)

            bold { append("Release date: ") }
            appendLine(pokemon.release_date)

            bold { append("Popularity: ") }
            appendLine(pokemon.popularity.toString())

            bold { append("Vote average: ") }
            appendLine(pokemon.vote_average.toString())
        }
    }
}