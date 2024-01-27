package com.example.pokedexmvvm.data.sources.remote

import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTOList
import javax.inject.Inject

class PokemonRemoteDataSource @Inject constructor(val pokemonAPI: PokeApiService){
    suspend fun getListPokemonID(): PokemonDTOList {
        return pokemonAPI.getPokemonList(1000)
    }

    suspend fun getPokemon(): PokemonDTO {
        return pokemonAPI.getPokemonData("bulbasur")
    }

}