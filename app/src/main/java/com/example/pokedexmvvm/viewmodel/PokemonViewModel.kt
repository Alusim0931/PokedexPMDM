package com.example.pokedexmvvm.viewmodel

import android.app.Application
import android.media.Image
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedexmvvm.dto.Pokemon
import com.example.pokedexmvvm.dto.Sprites
import com.example.pokedexmvvm.dto.Stat
import com.example.pokedexmvvm.dto.Type
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    application: Application,
    private val pokemon: Pokemon
): AndroidViewModel(application) {

    private var _pokemonName = MutableLiveData<String>()
    val pokemonName: LiveData<String> = _pokemonName

    private var _pokemonHeight = MutableLiveData<Int>()
    val pokemonHeight: LiveData<Int> = _pokemonHeight

    private var _pokemonWeight = MutableLiveData<Int>()
    val pokemonWeight: LiveData<Int> = _pokemonWeight

    private var _pokemonStats = MutableLiveData<List<Stat>>()
    val pokemonStats: LiveData<List<Stat>> = _pokemonStats

    private var _pokemonTypes = MutableLiveData<List<Type>>()
    val pokemonTypes: LiveData<List<Type>> = _pokemonTypes

    private var _pokemonId = MutableLiveData<Int>()
    val pokemonId: LiveData<Int> = _pokemonId

    private var _pokemonExp = MutableLiveData<Int>()
    val pokemonExp: LiveData<Int> = _pokemonExp

    private var _pokemonSprite = MutableLiveData<Sprites>()
    val pokemonSprite: LiveData<Sprites> = _pokemonSprite


    init {
        _pokemonName.value = pokemon.name

        _pokemonHeight.value = pokemon.height

        _pokemonWeight.value = pokemon.weight

        _pokemonStats.value = pokemon.stats

        _pokemonTypes.value = pokemon.types

        _pokemonId.value = pokemon.id

        _pokemonExp.value = pokemon.base_experience

        _pokemonSprite.value = pokemon.sprites

    }
    fun getPokemonNameLiveData(): LiveData<String> {
        return pokemonName
    }

    fun getPokemonHeightLiveData(): LiveData<Int> {
        return pokemonHeight
    }

    fun getPokemonWeightLiveData(): LiveData<Int> {
        return pokemonWeight
    }

    fun getPokemonStatsLiveData(): LiveData<List<Stat>> {
        return pokemonStats
    }

    fun getPokemonTypesLiveData(): LiveData<List<Type>> {
        return pokemonTypes
    }

    fun getPokemonIdLiveData(): LiveData<Int> {
        return pokemonId
    }

    fun getPokemonExpLiveData(): LiveData<Int> {
        return pokemonExp
    }

    fun getPokemonSpriteLiveData(): LiveData<Sprites> {
        return pokemonSprite
    }
    
}
