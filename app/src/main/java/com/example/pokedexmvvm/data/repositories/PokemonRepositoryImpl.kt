package com.example.pokedexmvvm.data.repositories


import com.example.pokedexmvvm.domain.repositories.IPokemonDetailRepository
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.data.sources.local.LocalDataPokemonSource
import com.example.pokedexmvvm.domain.models.Pokemon
import com.example.pokedexmvvm.mappers.PokemonDataMapper
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(val PokemonLocaldatasource: LocalDataPokemonSource): IPokemonDetailRepository {

    override suspend fun getPokemonData(name: String): Pokemon {
        val pokemonDTO = PokemonLocaldatasource.getPokemonJson("ditto.json")
        return revertPokemon(pokemonDTO)
    }

   fun revertPokemon(pokemonDTO: PokemonDTO): Pokemon {
        return PokemonDataMapper.TransformPokemonfromDTO(pokemonDTO)
    }
}