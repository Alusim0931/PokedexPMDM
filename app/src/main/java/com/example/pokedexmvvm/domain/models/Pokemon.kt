package com.example.pokedexmvvm.domain.models

import com.example.pokedexmvvm.data.sources.remote.DTO.Sprites
import com.example.pokedexmvvm.data.sources.remote.DTO.Stat
import com.example.pokedexmvvm.data.sources.remote.DTO.Type

data class Pokemon(
    val name: String,
    val height: Float,
    val weight: Float,
    val baseExp: Int,
    val id: Int,
    val sprite: Sprites,
    val stats: List<Stat>,
    val types: List<Type>
)

