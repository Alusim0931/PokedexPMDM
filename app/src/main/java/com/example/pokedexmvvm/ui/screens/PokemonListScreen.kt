package com.example.pokedexmvvm.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pokedex2.ui.theme.PrimaryPokedexColor
import com.example.pokedexmvvm.ui.viewmodels.PokemonListViewModel
import com.example.pokedexmvvm.ui.viewmodels.PokemonViewModel

@Composable
fun PokemonListScreen(
    listViewModel: PokemonListViewModel,
    detailviewmodel: PokemonViewModel,
    navController: NavHostController
) {
    val pokemonList by listViewModel.pokemonList.observeAsState()

    if (pokemonList != null) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(PrimaryPokedexColor)
        ) {

            items(pokemonList?.pokemonDTOSList!!.size) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            detailviewmodel.initialized(name = pokemonList!!.pokemonDTOSList[it])
                            navController.navigate("PokemonDetailScreen")
                        },
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = pokemonList!!.pokemonDTOSList[it].capitalize(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "#$it",
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                    }
                }
            }
        }
    } else {
        CircularProgressIndicator()
    }
}