package com.example.pokedexmvvm.domain.usercases

import com.example.pokedexmvvm.data.repositories.PokemonListRepositoryImpl
import com.example.pokedexmvvm.domain.models.PokemonList

import javax.inject.Inject




class GetPokemonListUseCase @Inject constructor(private val pokemonRepository: PokemonListRepositoryImpl) {
    suspend fun getPokemonList(limit: Int): PokemonList {
        return pokemonRepository.getPokemonList(limit)
    }
}