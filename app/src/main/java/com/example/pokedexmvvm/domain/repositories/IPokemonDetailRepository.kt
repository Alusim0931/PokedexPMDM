package com.example.pokedexmvvm.domain.repositories

import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.domain.models.Pokemon

interface IPokemonDetailRepository  {

    suspend fun getPokemonData(name: String): Pokemon

}