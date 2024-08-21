package com.example.rajennadal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rajennadal.model.Personaje
import com.example.rajennadal.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PersonajeViewModel : ViewModel() {
    private val repository = RickAndMortyRepository()

    private val _personaje = MutableStateFlow<Personaje?>(null)
    val personaje: StateFlow<Personaje?> = _personaje

    fun cargarPersonaje(personajeId: Int) {
        viewModelScope.launch {
            val result = repository.getPersonajeById(personajeId)
            _personaje.value = result
        }
    }
}