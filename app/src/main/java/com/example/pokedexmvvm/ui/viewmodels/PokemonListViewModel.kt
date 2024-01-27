package com.example.pokedexmvvm.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexmvvm.domain.models.Pokemon
import com.example.pokedexmvvm.domain.models.PokemonList
import com.example.pokedexmvvm.domain.usercases.GetPokemonDatailUseCase
import com.example.pokedexmvvm.domain.usercases.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val useCase: GetPokemonListUseCase): ViewModel(){

    private var _pokemonlist= MutableLiveData<PokemonList?>()
    val pokemonlist: MutableLiveData<PokemonList?> = _pokemonlist

    fun initializedList() {
        viewModelScope.launch {
            _pokemonlist.postValue(withContext(Dispatchers.IO) {
                useCase.getPokemonList()
            })
        }
    }
}