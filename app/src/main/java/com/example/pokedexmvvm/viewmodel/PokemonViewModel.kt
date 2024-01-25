package com.example.pokedexmvvm.viewmodel

import android.app.Application
import android.media.Image
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmvvm.dto.Pokemon
import com.example.pokedexmvvm.dto.Sprites
import com.example.pokedexmvvm.dto.Stat
import com.example.pokedexmvvm.dto.Type
import com.example.pokedexmvvm.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(val pokemonRepository: PokemonRepository): ViewModel(){

    private var _pokemon = MutableLiveData<Pokemon>()

    // Utiliza viewModelScope para realizar operaciones en el hilo principal
    init {
        viewModelScope.launch {
            _pokemon.postValue(pokemonRepository.getPokemon())
        }
    }

    val pokemon: LiveData<Pokemon> = _pokemon
}



