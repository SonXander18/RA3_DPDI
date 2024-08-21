package com.example.rajennadal.ui.theme


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.tv.material3.Text
import com.example.rajennadal.model.Personaje

@Composable
fun ListaPersonajesScreen(onPersonajeSelected: (Personaje) -> Unit, onSalir: () -> Unit) {
    val personajes = listOf(
        Personaje(1, "Rick Sanchez", "https://rickandmortyapi.com/api/character/avatar/1.jpeg", "Rick es un científico alcohólico misántropo que parece no preocuparse por nada, incluida su propia familia. Es el padre de Beth Smith y el abuelo de Morty y Summer Smith.", "Humano"),
        Personaje(2, "Morty Smith", "https://rickandmortyapi.com/api/character/avatar/2.jpeg", "Morty es un adolescente nervioso y fácilmente influenciable que es arrastrado a las aventuras interdimensionales de su abuelo Rick.", "Humano"),
        Personaje(3, "Summer Smith", "https://rickandmortyapi.com/api/character/avatar/3.jpeg", "Summer es la hermana mayor de Morty. Ella es una adolescente más convencional que a menudo se preocupa por mejorar su estatus social en la escuela.", "Humano"),
        Personaje(4, "Beth Smith", "https://rickandmortyapi.com/api/character/avatar/4.jpeg", "Beth es la hija de Rick y madre de Summer y Morty. Ella es una cirujana cardíaca de caballos y a menudo se siente insegura sobre sus decisiones de vida.", "Humano"),
        Personaje(5, "Jerry Smith", "https://rickandmortyapi.com/api/character/avatar/5.jpeg", "Jerry es el padre de Summer y Morty y el esposo de Beth. Es inseguro y a menudo incompetente, lo que lo pone en conflicto con Rick.", "Humano"),
        Personaje(6, "Abadango Cluster Princess", "https://rickandmortyapi.com/api/character/avatar/6.jpeg", "La Princesa del Cluster Abadango es un personaje alienígena que aparece brevemente en la serie.", "Alien"),
        Personaje(7, "Abradolf Lincler", "https://rickandmortyapi.com/api/character/avatar/7.jpeg", "Abradolf Lincler es un experimento fallido de Rick que combina el ADN de Abraham Lincoln y Adolf Hitler.", "Experimento genético"),
        Personaje(8, "Adjudicator Rick", "https://rickandmortyapi.com/api/character/avatar/8.jpeg", "Adjudicator Rick es una versión alternativa de Rick de otra dimensión que sirve como juez en el Consejo de Ricks.", "Humano")
    )

    LazyColumn {
        items(personajes) { personaje ->
            Button(
                onClick = { onPersonajeSelected(personaje) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = personaje.nombre)
            }
        }

        // Botón de salir
        item {
            Button(
                onClick = { onSalir() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Salir")
            }
        }
    }
}
