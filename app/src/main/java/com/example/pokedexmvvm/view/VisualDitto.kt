package com.example.pokedexmvvm

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisualDitto() {
    var expanded by remember { mutableStateOf(false) }

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
            ImageDitto()
        }

        // Texto del tipo (Normal)
        Text(
            text = "Normal",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = Color.Black // Cambia Color.White al color de texto que desees
        )

        Stadistics()
    }
}

@Composable
fun Stadistics() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        PokemonStatsBar("HP", Random.nextInt(256), Color.Red)
        PokemonStatsBar("Atk", Random.nextInt(256), Color.Green)
        PokemonStatsBar("Def", Random.nextInt(256), Color.Blue)
        PokemonStatsBar("Sp. Atk", Random.nextInt(256), Color.Yellow)
        PokemonStatsBar("Sp. Def", Random.nextInt(256), Color.Magenta)
        PokemonStatsBar("Speed", Random.nextInt(256), Color.Cyan)
    }
}

@Composable
fun PokemonStatsBar(statName: String, statValue: Int, barColor: Color) {
    val maxValue = 255

    val percentage = (statValue / maxValue.toFloat()) * 100

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(2.dp)
            .background(barColor, RoundedCornerShape(8.dp))
    ) {
        val progressBarWidth = with(LocalDensity.current) { (percentage / 100f) * 200.dp.toPx() } // Ajusta el valor 200.dp según sea necesario

        LinearProgressIndicator(
            progress = percentage,
            modifier = Modifier
                .fillMaxHeight()
                .width(progressBarWidth.dp)
                .padding(2.dp),
            color = Color.Transparent // Establecer el color de la barra de progreso como transparente
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
fun ImageDitto() {
    Image(
        painterResource(id = R.drawable.ditto),
        contentDescription = "Null",
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(16.dp))
    )
}