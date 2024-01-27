package com.example.pokedexmvvm.domain.repositories


import com.example.pokedexmvvm.domain.models.Pokemon
import com.example.pokedexmvvm.domain.models.PokemonList

interface IPokemonListRepository {
    suspend fun getPokemonList(): PokemonList
}