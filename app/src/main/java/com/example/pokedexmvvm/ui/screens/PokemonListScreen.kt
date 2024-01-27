package com.example.pokedexmvvm.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.pokedexmvvm.ui.viewmodels.PokemonListViewModel
import com.example.pokedexmvvm.ui.viewmodels.PokemonViewModel

@Composable
fun PokemonListScreen(listViewModel: PokemonListViewModel,
detailviewmodel: PokemonViewModel, ) {

    val pokemonList by listViewModel.pokemonlist.observeAsState()
}