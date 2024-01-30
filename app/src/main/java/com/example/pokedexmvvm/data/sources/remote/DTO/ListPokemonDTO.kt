package com.example.pokedexmvvm.data.sources.remote.DTO

data class ListPokemonDTO(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)