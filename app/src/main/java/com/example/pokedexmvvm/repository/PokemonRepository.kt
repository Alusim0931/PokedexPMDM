package com.example.pokedexmvvm.repository

import android.content.Context
import com.example.pokedexmvvm.dto.Pokemon
import com.example.pokedexmvvm.source.local.LocalDataPokemonSource
import javax.inject.Inject

class PokemonRepository @Inject constructor(val datasource: LocalDataPokemonSource) {

    fun getPokemon(): Pokemon {
        return datasource.getPokemonJson("ditto.json")
    }
}