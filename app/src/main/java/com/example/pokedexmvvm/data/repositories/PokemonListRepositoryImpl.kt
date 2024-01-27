package com.example.pokedexmvvm.data.repositories

import com.example.pokedexmvvm.data.sources.local.LocalDataPokemonSource
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTOList
import com.example.pokedexmvvm.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedexmvvm.domain.models.PokemonList
import com.example.pokedexmvvm.domain.repositories.IPokemonListRepository
import com.example.pokedexmvvm.mappers.PokemonDataMapper
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(val pokemonRemoteDataource: PokemonRemoteDataSource): IPokemonListRepository{
    override suspend fun getPokemonList(): PokemonList {
        val pokeList = pokemonRemoteDataource.getListPokemonID()
        return PokemonDataMapper.convertDTOfromList(pokeList)
    }


}