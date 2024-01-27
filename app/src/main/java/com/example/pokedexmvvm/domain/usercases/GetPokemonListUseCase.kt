package com.example.pokedexmvvm.domain.usercases

import com.example.pokedexmvvm.data.repositories.PokemonDetailRepositoryImpl
import com.example.pokedexmvvm.data.repositories.PokemonListRepositoryImpl
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTOList
import com.example.pokedexmvvm.domain.models.Pokemon
import com.example.pokedexmvvm.domain.models.PokemonList

import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val pokemonRepository: PokemonListRepositoryImpl) {
    suspend fun getPokemonList(): PokemonList {
        return pokemonRepository.getPokemonList()
    }
}