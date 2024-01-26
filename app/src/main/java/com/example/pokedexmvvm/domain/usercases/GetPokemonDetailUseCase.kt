package com.example.pokedexmvvm.domain.usercases

import com.example.pokedexmvvm.data.repositories.PokemonDetailRepositoryImpl
import com.example.pokedexmvvm.domain.repositories.IPokemonDetailRepository
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonList
import com.example.pokedexmvvm.domain.models.Pokemon
import javax.inject.Inject

class GetPokemonDatailUseCase @Inject constructor(private val pokemonRepository: PokemonDetailRepositoryImpl) {

    suspend fun getPokemonDetail(name: String): Pokemon {
        return pokemonRepository.getPokemonData(name)
    }

}