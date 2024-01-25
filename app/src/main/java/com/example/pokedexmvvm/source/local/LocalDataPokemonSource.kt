package com.example.pokedexmvvm.source.local

import android.app.Application
import android.content.Context
import com.example.pokedexmvvm.dto.Pokemon
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class LocalDataPokemonSource  @Inject constructor(val application: Application)
{
fun getPokemonJson(filename: String): Pokemon {
    val pokemonJson = accesJsonAccess(filename)
    val pokemon = JSONtoModel(pokemonJson)

    return pokemon
}

fun accesJsonAccess(json: String): InputStream {
    //Acceso al Json desde assets
    return application.assets.open(json)
}

fun JSONtoModel(jsonObject: InputStream): Pokemon {
    val gson = Gson()
    val reader = InputStreamReader(jsonObject)
    val pokemon: Pokemon = gson.fromJson(reader, Pokemon::class.java)
    reader.close()

    return pokemon
}
}