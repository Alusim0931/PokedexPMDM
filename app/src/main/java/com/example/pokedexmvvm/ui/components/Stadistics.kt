package com.example.pokedexmvvm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex2.ui.theme.AtkColor
import com.example.pokedex2.ui.theme.DefColor
import com.example.pokedex2.ui.theme.HPColor
import com.example.pokedex2.ui.theme.SpAtkColor
import com.example.pokedex2.ui.theme.SpDefColor
import com.example.pokedex2.ui.theme.SpdColor
import com.example.pokedexmvvm.data.sources.remote.DTO.Stat

@Composable
fun Stadistics(stats: List<Stat>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        stats.forEach { stat ->
            PokemonStatsBar(statName = stat.stat.name, statValue = stat.base_stat)
        }
    }
}
@Composable
fun PokemonStatsBar(statName: String, statValue: Int) {
    val maxValue = 255

    val percentage = (statValue / maxValue.toFloat()) * 100

    val barColor = when (statName) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.Gray
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(2.dp)
            .background(barColor, RoundedCornerShape(8.dp))
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
            text = statName.capitalize(),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp),
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}