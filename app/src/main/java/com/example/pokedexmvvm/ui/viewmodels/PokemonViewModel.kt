package com.example.pokedexmvvm.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmvvm.domain.usercases.GetPokemonDatailUseCase
import com.example.pokedexmvvm.data.sources.remote.DTO.PokemonDTO
import com.example.pokedexmvvm.domain.models.Pokemon

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val useCase: GetPokemonDatailUseCase): ViewModel(){

    private var _pokemonDTO = MutableLiveData<Pokemon?>()

    val pokemonDTO: MutableLiveData<Pokemon?> = _pokemonDTO

    private suspend fun initialized(name: String) {
        viewModelScope.launch {
            _pokemonDTO.postValue(withContext(Dispatchers.IO) {
                useCase.getPokemonDetail(name)
            })
        }
    }



}




