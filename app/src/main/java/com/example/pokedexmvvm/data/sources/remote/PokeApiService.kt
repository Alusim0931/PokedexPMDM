package com.example.pokedexmvvm.data.sources.remote

import com.example.pokedexmvvm.data.sources.remote.DTO.ListPokemonDTO
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.domain.models.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): ListPokemonDTO

    @GET("pokemon/{name}")
    suspend fun getPokemonData(@Path("name") name: String): PokemonDTO
}