package com.example.rajennadal.repository

import com.example.rajennadal.model.Personaje
import com.example.rajennadal.network.RickAndMortyApiService

import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Retrofit



class RickAndMortyRepository {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/") // URL base de la API de Rick and Morty
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val service = retrofit.create(RickAndMortyApiService::class.java)

    suspend fun getPersonajeById(id: Int): Personaje {
        return service.getCharacterById(id)
    }
}