package com.example.pokedexmvvm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex2.ui.theme.AtkColor
import com.example.pokedex2.ui.theme.DefColor
import com.example.pokedex2.ui.theme.HPColor
import com.example.pokedex2.ui.theme.SpAtkColor
import com.example.pokedex2.ui.theme.SpDefColor
import com.example.pokedex2.ui.theme.SpdColor
import com.example.pokedexmvvm.ui.viewmodels.PokemonViewModel

@Composable
fun Stadistics(pokemonViewModel: PokemonViewModel) {
    val pokemon by pokemonViewModel.pokemonDTO.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        pokemon?.stats?.forEach { stat ->
            PokemonStatsBar(statName = stat.stat.name, statValue = stat.base_stat)
        }
    }
}

@Composable
fun PokemonStatsBar(statName: String, statValue: Int) {
    val maxValue = 255

    val percentage = (statValue / maxValue.toFloat()) * 100

    val color = when (statName) {
        "HP" -> HPColor
        "Atk" -> AtkColor
        "Def" -> DefColor
        "Sp. Atk" -> SpAtkColor
        "Sp. Def" -> SpDefColor
        "Speed" -> SpdColor
        else -> Color.Gray // Otra opción predeterminada
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(2.dp)
            .background(color, RoundedCornerShape(8.dp))
    ) {
        val progressBarWidth = with(LocalDensity.current) { (percentage / 100f) * 200.dp.toPx() }

        LinearProgressIndicator(
            progress = percentage,
            modifier = Modifier
                .fillMaxHeight()
                .width(progressBarWidth.dp)
                .padding(2.dp),
            color = Color.Transparent
        )

        Text(
            text = "$statValue/$maxValue",
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = statName,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ImageDitto(pokemonViewModel: PokemonViewModel) {
    val pokemon by pokemonViewModel.pokemonDTO.observeAsState()
    Image(
        painterResource(id = R.drawable.ditto),
        contentDescription = "Null",
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(16.dp))
    )
}

@Composable
fun PokemonTypes(pokemonViewModel: PokemonViewModel) {
    val pokemon by pokemonViewModel.pokemonDTO.observeAsState()

    val types = pokemon?.types

    if (types?.isNotEmpty() == false) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            for (type in types) {
                Text(
                    text = type.type.name,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        //.background(getTypeColor(type.type.name), RoundedCornerShape(16.dp))
                        .padding(8.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun measurement(pokemonViewModel: PokemonViewModel) {
    // Do something with the Pokemon object if needed
}
