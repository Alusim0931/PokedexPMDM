package com.example.pokedexmvvm.source.local

import android.content.Context
import com.example.pokedexmvvm.dto.Pokemon
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader

fun getPokemonJson(filename: String,context: Context): Pokemon {
    val pokemonJson = accesJsonAccess(filename, context)
    val pokemon = JSONtoModel(pokemonJson)

    return pokemon
}

fun accesJsonAccess(json: String, context: Context): InputStream {
    //Acceso al Json desde assets
    return context.assets.open(json)
}

fun JSONtoModel(jsonObject: InputStream): Pokemon {
    val gson = Gson()
    val reader = InputStreamReader(jsonObject)
    val pokemon: Pokemon = gson.fromJson(reader, Pokemon::class.java)
    reader.close()

    return pokemon
}