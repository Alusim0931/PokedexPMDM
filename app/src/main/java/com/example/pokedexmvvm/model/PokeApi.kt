package com.example.pokedexmvvm.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int): String

    @GET("pokemon/{name}")
    suspend fun getPokemonData(@Path("name") name: String): String
}