package com.example.pokedexmvvm.model

import androidx.compose.ui.graphics.Color

data class PokemonType(val typeName: String, val colors: List<Color>)

object PokemonTypeProvider {
    object PokemonTypeProvider {
        val normalType =
            PokemonType("Normal", listOf(Color.Gray, Color.Black, Color.DarkGray, Color.LightGray))

        val fireType = PokemonType(
            "Fuego",
            listOf(Color(0xFFFF5722), Color.White, Color(0xFFF4511E), Color(0xFFFFAB91))
        )

        val waterType = PokemonType(
            "Agua",
            listOf(Color(0xFF2196F3), Color.White, Color(0xFF1976D2), Color(0xFF90CAF9))
        )

        val grassType = PokemonType(
            "Planta",
            listOf(Color(0xFF4CAF50), Color.White, Color(0xFF388E3C), Color(0xFFA5D6A7))
        )

        val electricType = PokemonType(
            "Eléctrico",
            listOf(Color.Yellow, Color.Black, Color(0xFFFFD54F), Color(0xFFFFF176))
        )

        val iceType = PokemonType(
            "Hielo",
            listOf(Color.Cyan, Color.Black, Color(0xFF81D4FA), Color(0xFFB3E5FC))
        )

        val fightingType = PokemonType(
            "Lucha",
            listOf(Color(0xFF795548), Color.White, Color(0xFFA1887F), Color(0xFF8D6E63))
        )

        val poisonType = PokemonType(
            "Veneno",
            listOf(Color(0xFF9C27B0), Color.White, Color(0xFF7B1FA2), Color(0xFFBA68C8))
        )

        val groundType = PokemonType(
            "Tierra",
            listOf(Color(0xFF8D6E63), Color.White, Color(0xFF5D4037), Color(0xFFBCAAA4))
        )

        val flyingType = PokemonType(
            "Volador",
            listOf(Color(0xFF03A9F4), Color.White, Color(0xFF0288D1), Color(0xFF64B5F6))
        )

        val psychicType = PokemonType(
            "Psíquico",
            listOf(Color(0xFFFF4081), Color.White, Color(0xFFF50057), Color(0xFFFF80AB))
        )

        val bugType = PokemonType(
            "Bicho",
            listOf(Color(0xFF8BC34A), Color.Black, Color(0xFF689F38), Color(0xFFC5E1A5))
        )
        val rockType = PokemonType(
            "Roca",
            listOf(Color(0xFF795548), Color.White, Color(0xFFA1887F), Color(0xFFD7CCC8))
        )
        val ghostType = PokemonType(
            "Fantasma",
            listOf(Color(0xFF673AB7), Color.White, Color(0xFF512DA8), Color(0xFF9575CD))
        )
        val dragonType = PokemonType(
            "Dragón",
            listOf(Color(0xFF2196F3), Color.White, Color(0xFF1976D2), Color(0xFF90CAF9))
        )
        val darkType = PokemonType(
            "Siniestro",
            listOf(Color(0xFF212121), Color.White, Color(0xFF000000), Color(0xFF616161))
        )
        val steelType = PokemonType(
            "Acero",
            listOf(Color(0xFF607D8B), Color.White, Color(0xFF455A64), Color(0xFF90A4AE))
        )
        val fairyType = PokemonType(
            "Hada",
            listOf(Color(0xFFFF4081), Color.White, Color(0xFFF50057), Color(0xFFFF80AB))
        )
    }
}
