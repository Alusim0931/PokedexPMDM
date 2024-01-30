package com.example.pokedexmvvm.mappers

import com.example.pokedexmvvm.data.sources.remote.DTO.ListPokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.domain.models.Pokemon
import com.example.pokedexmvvm.domain.models.PokemonList
import javax.inject.Inject

class PokemonDataMapper @Inject constructor(val pokemonDTO: PokemonDTO) {

    companion object{
        fun TransformPokemonfromDTO(pokemonDTO: PokemonDTO): Pokemon {
            val pokemon = Pokemon(
                pokemonDTO.name,
                pokemonDTO.height.toFloat(),
                pokemonDTO.weight.toFloat(),
                pokemonDTO.base_experience,
                pokemonDTO.id,
                pokemonDTO.sprites,
                pokemonDTO.stats,
                pokemonDTO.types
            )
            return pokemon
        }
        fun convertDTOfromList(listpokemon: ListPokemonDTO): PokemonList {
            val nameListPokemon = mutableListOf<String>()


            for (pokemon in listpokemon.results) {
                nameListPokemon.add(pokemon.name)
            }
            return PokemonList(nameListPokemon)
        }
    }


}