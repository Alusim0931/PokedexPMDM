package com.example.pokedexmvvm.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pokedexmvvm.ui.components.PokemonHeight
import com.example.pokedexmvvm.ui.components.PokemonName
import com.example.pokedexmvvm.ui.components.PokemonTypes
import com.example.pokedexmvvm.ui.components.PokemonWeight
import com.example.pokedexmvvm.ui.components.Stadistics
import com.example.pokedexmvvm.ui.viewmodels.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(pokemonViewModel: PokemonViewModel, navController: NavController) {
    var expanded by remember { mutableStateOf(false) }

    val pokemon by pokemonViewModel.pokemonDTO.observeAsState()

    LaunchedEffect(true) {
        expanded = true
    }

    if (pokemon != null) {
        Column {
            // TopAppBar
            Surface(shadowElevation = 3.dp, modifier = Modifier.background(color = Color.Red)) {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .clickable { navController.navigate("PokemonListScreen") }
                                )
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = "Pokédex"
                                )
                            }
                            Spacer(modifier = Modifier.width(150.dp)) // Añadido espaciador

                            pokemon?.let {
                                Text(
                                    text = "# ${it.id}",
                                    modifier = Modifier.padding(8.dp),
                                    color = Color.White
                                )
                            }
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red)
                )
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp)
                    .animateContentSize(),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column {
                    AsyncImage(model = pokemon!!.sprite.front_default,
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxSize())
                }
            }
            pokemon?.let { PokemonName(it.name) }
            pokemon?.let { PokemonTypes(it.types) }
            pokemon?.let { Stadistics(it.stats) }
            pokemon?.let { PokemonHeight(it.height) }
            pokemon?.let { PokemonWeight(it.weight) }
        }
    }
}


