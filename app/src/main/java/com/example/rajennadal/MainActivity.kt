package com.example.rajennadal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rajennadal.ui.theme.RAJennadalTheme
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import com.example.rajennadal.navigation.AppNavigation
import com.example.rajennadal.model.Personaje
import coil.compose.AsyncImage
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RAJennadalTheme {
                AppNavigation()
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetallesPersonajesScreen(personaje: Personaje) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "ID: ${personaje.id}")
        Text(text = "Título: ${personaje.nombre}")
        AsyncImage(
            model = personaje.imagen,
            contentDescription = "Imagen de ${personaje.nombre}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp)
                .clip(CircleShape)
        )
        Text(text = "Descripción: ${personaje.descripcion}")
        Text(text = "Autor: ${personaje.especie}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RAJennadalTheme {
        DetallesPersonajesScreen(
            Personaje(
                id = 1,
                nombre = "Rick Sanchez",
                imagen = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                descripcion = "Rick es un científico alcohólico misántropo que parece no preocuparse por nada, incluida su propia familia.",
                especie = "Humano"
            )
        )
    }
}