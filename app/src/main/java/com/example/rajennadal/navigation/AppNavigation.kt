package com.example.rajennadal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.example.rajennadal.model.Personaje
import com.example.rajennadal.ui.theme.DetallesPersonajesScreen
import com.example.rajennadal.ui.theme.MenuScreen
import com.example.rajennadal.ui.theme.ListaPersonajesScreen
import com.example.rajennadal.ui.theme.AcercaDeScreen





@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val selectedPersonaje = remember { mutableStateOf<Personaje?>(null) }

    NavHost(navController = navController, startDestination = "menu") {
        composable("menu") {
            MenuScreen(navController = navController, onSalir = { navController.popBackStack() })
        }
        composable("personajes") {
            ListaPersonajesScreen(
                onPersonajeSelected = { personaje ->
                    selectedPersonaje.value = personaje
                    navController.navigate("detalles_personaje")
                },
                onSalir = { navController.popBackStack() }
            )
        }
        composable("detalles_personaje") {
            selectedPersonaje.value?.let { personaje ->
                DetallesPersonajesScreen(personaje = personaje, onSalir = { navController.popBackStack() })
            }
        }
        composable("acercaDe") {
            AcercaDeScreen(navController = navController)

        }
    }
}
