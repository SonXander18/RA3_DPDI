package com.example.rajennadal.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.example.rajennadal.model.Personaje

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DetallesPersonajesScreen(personaje: Personaje, onSalir: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "ID: ${personaje.id}",
            style = MaterialTheme.typography.bodyLarge
        )
        Text(
            text = "Nombre: ${personaje.nombre}",
            style = MaterialTheme.typography.bodyLarge
        )
        AsyncImage(
            model = personaje.imagen,
            contentDescription = "Imagen de ${personaje.nombre}",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(4.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Descripción: ${personaje.descripcion}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Especie: ${personaje.especie}",
            style = MaterialTheme.typography.bodyMedium
        )
        // Botón de salir
        Button(onClick = onSalir) {
            Text(text = "Salir")
        }
    }
}