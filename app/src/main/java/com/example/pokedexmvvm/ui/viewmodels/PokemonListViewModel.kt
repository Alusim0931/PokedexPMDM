package com.example.pokedexmvvm.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmvvm.domain.models.PokemonList
import com.example.pokedexmvvm.domain.usercases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

private const val MAX_POKES = 1500

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val useCase: GetPokemonListUseCase): ViewModel(){

    private var _pokemonList = MutableLiveData<PokemonList?>()
    val pokemonList: LiveData<PokemonList?> = _pokemonList

   init {
        viewModelScope.launch {
            _pokemonList.postValue(withContext(Dispatchers.IO) {
                useCase.getPokemonList(MAX_POKES)
            })
        }
    }
}