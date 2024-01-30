package com.example.pokedexmvvm.data.repositories

import com.example.pokedexmvvm.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedexmvvm.domain.models.PokemonList
import com.example.pokedexmvvm.domain.repositories.IPokemonListRepository
import com.example.pokedexmvvm.mappers.PokemonDataMapper
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(private val pokemonRemoteDataSource: PokemonRemoteDataSource): IPokemonListRepository{

    override suspend fun getPokemonList(limit: Int): PokemonList {
        val pokemonList = pokemonRemoteDataSource.getListPokemonID(limit)

        return PokemonDataMapper.convertDTOfromList(pokemonList)

    }

}