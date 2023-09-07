package com.devdcruz.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract.Root
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


        //i have to search an alternative for getParcelable beacuse is deprecate
        val title = intent.getParcelable<Pokemon>(EXTRA_POKEMON)
        binding.titleDetail.text = title
    }
}