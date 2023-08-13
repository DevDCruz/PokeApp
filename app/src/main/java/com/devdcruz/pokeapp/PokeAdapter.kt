package com.devdcruz.pokeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devdcruz.pokeapp.databinding.ViewPokemonItemBinding

class PokeAdapter(
    private val pokemonList: List<Pokemon>,
    private val pokemonClickedListener: (Pokemon) -> Unit
): RecyclerView.Adapter<PokeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewPokemonItemBinding
            .inflate(LayoutInflater.from(parent.context),parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = pokemonList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
        holder.itemView.setOnClickListener { pokemonClickedListener(pokemon) }
    }

    class ViewHolder(private val binding: ViewPokemonItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(pokemon: Pokemon){
            binding.tvNamePok.text = pokemon.name
            binding.tvTypePok.text = pokemon.type
            Glide.with(binding.root.context)
                .load(pokemon.pokImage).into(binding.ivPokemon)
        }

    }


}