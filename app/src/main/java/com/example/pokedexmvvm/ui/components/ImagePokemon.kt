package com.example.pokedexmvvm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedexmvvm.R
import com.example.pokedexmvvm.data.sources.remote.DTO.Sprites

/*
@Composable
fun ImagePokemon(sprites: Sprites) {
    Image(
        painterResource(id = R.drawable.ditto),
        contentDescription = "Null",
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(16.dp))
    )
    AsyncImage(
        model = sprites.front_default ,
        contentDescription = "ImagenPokemon",
        modifier = Modifier
            .fillMaxSize()
    )

}*/