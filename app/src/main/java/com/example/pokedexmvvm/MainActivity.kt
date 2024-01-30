package com.example.pokedexmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexmvvm.ui.screens.PokemonDetailScreen
import com.example.pokedexmvvm.ui.screens.PokemonListScreen
import com.example.pokedexmvvm.ui.theme.PokedexMVVMTheme
import com.example.pokedexmvvm.ui.viewmodels.PokemonListViewModel
import com.example.pokedexmvvm.ui.viewmodels.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val pokemonDetailviewmodel: PokemonViewModel = hiltViewModel()
                    val pokemonListviewmodel: PokemonListViewModel = hiltViewModel()
                    //VisualDitto(pokemonDetailviewmodel)
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "PokemonListScreen") {

                        composable("PokemonListScreen") {
                            PokemonListScreen(
                                pokemonListviewmodel,
                                pokemonDetailviewmodel ,
                                 navController) }
                        composable("PokemonDetailScreen"){
                            PokemonDetailScreen(
                                pokemonDetailviewmodel,
                                navController)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexMVVMTheme {
        Greeting("Android")
    }
}