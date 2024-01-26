package com.example.pokedexmvvm.data.sources.local

import android.app.Application
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject

class LocalDataPokemonSource @Inject constructor(val application: Application)
{
fun getPokemonJson(filename: String): PokemonDTO {
    val pokemonJson = accesJsonAccess(filename)
    val pokemon = JSONtoModel(pokemonJson)

    return pokemon
}

fun accesJsonAccess(json: String): InputStream {
    //Acceso al Json desde assets
    return application.assets.open(json)
}

fun JSONtoModel(jsonObject: InputStream): PokemonDTO {
    val gson = Gson()
    val reader = InputStreamReader(jsonObject)
    val pokemonDTO: PokemonDTO = gson.fromJson(reader, PokemonDTO::class.java)
    reader.close()

    return pokemonDTO
}
}