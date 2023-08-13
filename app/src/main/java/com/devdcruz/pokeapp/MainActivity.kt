package com.devdcruz.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.devdcruz.pokeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerV.adapter = PokeAdapter(
            listOf(
                Pokemon("Bulvasur", "Planta", "https://loremflickr.com/320/240?lock=1"),
                Pokemon("Ivisur", "Planta", "https://loremflickr.com/320/240?lock=2"),
                Pokemon("Venusaur", "Planta", "https://loremflickr.com/320/240?lock=3"),
                Pokemon("Squirtle", "Agua", "https://loremflickr.com/320/240?lock="),
                Pokemon("Wartottle", "Agua", "https://loremflickr.com/320/240?lock=5"),
                Pokemon("Blastoise", "Agua", "https://loremflickr.com/320/240?lock=6"),
                Pokemon("Charmader", "Fuego", "https://loremflickr.com/320/240?lock=7"),
                Pokemon("Charmaleon", "Fuego", "https://loremflickr.com/320/240?lock=8"),
                Pokemon("Charizard", "Fuego", "https://loremflickr.com/320/240?lock=9"),
            )
        ) {pokemon ->
            Toast
                .makeText(this@MainActivity, pokemon.name, Toast.LENGTH_LONG).show()
        }
    }
}