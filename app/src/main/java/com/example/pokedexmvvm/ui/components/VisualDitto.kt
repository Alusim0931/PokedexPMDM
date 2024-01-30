import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex2.ui.theme.AtkColor
import com.example.pokedex2.ui.theme.DefColor
import com.example.pokedex2.ui.theme.HPColor
import com.example.pokedex2.ui.theme.SpAtkColor
import com.example.pokedex2.ui.theme.SpDefColor
import com.example.pokedex2.ui.theme.SpdColor
import com.example.pokedex2.ui.theme.TypesColor
import com.example.pokedexmvvm.R
import com.example.pokedexmvvm.data.sources.remote.DTO.Stat
import com.example.pokedexmvvm.data.sources.remote.DTO.Type
import coil.compose.AsyncImage
import com.example.pokedexmvvm.data.sources.remote.DTO.Sprites

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
        val progressBarColor = when (statName) {
            "hp" -> HPColor
            "attack" -> AtkColor
            "defense" -> DefColor
            "special-attack" -> SpAtkColor
            "special-defense" -> SpDefColor
            "speed" -> SpdColor
            else -> Color.Gray
        }

        val progressBarWidth = with(LocalDensity.current) { (percentage / 100f) * 200.dp.toPx() }

        LinearProgressIndicator(
            progress = percentage,
            modifier = Modifier
                .fillMaxHeight()
                .width(progressBarWidth.dp)
                .padding(2.dp),
            color = Color.Transparent // Hacer la barra de progreso transparente
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

}

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
                // Pokemon con un solo tipo
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
                        text = type.type.name,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(6.dp)
                    )
                }
            } else if (types.size == 2) {
                // Pokemon con doble tipo
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    for (type in types) {
                        val typeColor = TypesColor.find { it.name == type.type.name }
                        val boxColor = typeColor?.color ?: Color.Gray

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(color = boxColor, shape = RoundedCornerShape(8.dp))
                                .padding(0.dp)
                        ) {
                            Text(
                                text = type.type.name,
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

@Composable
fun PokemonHeight(height: Float?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Verificar si la altura no es nula
        if (height != null) {
            // Mostrar altura
            Text(
                text = "Height: $height m",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.Black
            )
        }
    }
}

@Composable
fun PokemonWeight(weight: Float?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    ) {
        // Verificar si el peso no es nulo
        if (weight != null) {
            // Mostrar peso
            Text(
                text = "Weight: $weight kg",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                color = Color.Black
            )
        }
    }
}

@Composable
fun PokemonName(name: String) {
    Text(
        text = name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp),
        color = Color.Black,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}

