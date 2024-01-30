package com.example.pokedexmvvm.data.sources.remote

import com.example.pokedexmvvm.data.sources.remote.DTO.ListPokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.google.gson.Gson
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(val pokemonAPI: PokeApiService){

    private val gson = Gson()
    suspend fun getListPokemonID(limit: Int): ListPokemonDTO{
        return pokemonAPI.getPokemonList(limit)
    }

    suspend fun getPokemon(name: String): PokemonDTO {
        return pokemonAPI.getPokemonData(name)
    }

}