package com.example.pokedexmvvm.data.sources.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): String

    @GET("pokemon/{name}")
    suspend fun getPokemonData(@Path("name") name: String): String
}