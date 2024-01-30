package com.example.pokedexmvvm.data.repositories


import com.example.pokedexmvvm.domain.repositories.IPokemonDetailRepository
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.data.sources.local.LocalDataPokemonSource
import com.example.pokedexmvvm.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedexmvvm.domain.models.Pokemon
import com.example.pokedexmvvm.mappers.PokemonDataMapper
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val pokemonLocaldatasource: LocalDataPokemonSource,
    private val pokemonRemoteDataSource: PokemonRemoteDataSource): IPokemonDetailRepository {

    override suspend fun getPokemonData(name: String): Pokemon {
        val pokemonDTO: PokemonDTO = pokemonRemoteDataSource.getPokemon(name)
        return PokemonDataMapper.TransformPokemonfromDTO(pokemonDTO)
    }
}