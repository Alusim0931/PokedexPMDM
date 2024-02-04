package com.example.pokedexmvvm.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex2.ui.theme.TypesColor
import com.example.pokedexmvvm.data.sources.remote.DTO.Type

@Composable
fun PokemonTypes(types: List<Type>) {
    if (types.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (types.size == 1) {
                val type = types.first()
                val typeColor = TypesColor.find { it.name == type.type.name }
                val boxColor = typeColor?.color ?: Color.Gray

                Box(
                    modifier = Modifier
                        .background(color = boxColor, shape = RoundedCornerShape(8.dp))
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = type.type.name.capitalize(),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(6.dp),
                        textAlign = TextAlign.Center
                    )
                }
            } else if (types.size == 2) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (type in types) {
                        val typeColor = TypesColor.find { it.name == type.type.name }
                        val boxColor = typeColor?.color ?: Color.Gray

                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .background(color = boxColor, shape = RoundedCornerShape(8.dp))
                                .padding(4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = type.type.name.capitalize(),
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
