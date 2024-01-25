package com.example.pokedexmvvm.view

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedexmvvm.ImageDitto
//import com.example.pokedexmvvm.ImageDitto
import com.example.pokedexmvvm.PokemonTypes
import com.example.pokedexmvvm.Stadistics
import com.example.pokedexmvvm.viewmodel.PokemonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualDitto(pokemonViewModel: PokemonViewModel) {
    var expanded by remember { mutableStateOf(false) }
    val pokemon by pokemonViewModel.pokemon.observeAsState()
    LaunchedEffect(true) {
        expanded = true // Expandir automáticamente al inicio
    }

    Column {
        // TopAppBar
        Surface(shadowElevation = 3.dp, modifier = Modifier.background(color = Color.Red)) {
            TopAppBar(
                title = {
                    Row {
                        Icon(
                            Icons.Default.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier.padding(8.dp)
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "Pokédex"
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color.Red)
            )
        }

        // Imagen dentro del Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
                .animateContentSize(), // Aplicar animación al tamaño del Card
            shape = RoundedCornerShape(16.dp),
        ) {
           pokemon?.sprites
        }

        // Texto del tipo
        val firstType = pokemon?.types?.firstOrNull()?.type?.name
        if (!firstType.isNullOrEmpty()) {
            Text(
                text = firstType,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                color = Color.Black
            )
        }

        Stadistics(pokemonViewModel)
        PokemonTypes(pokemonViewModel)
    }
}
