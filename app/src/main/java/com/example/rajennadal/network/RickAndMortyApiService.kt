package com.example.rajennadal.network

import com.example.rajennadal.model.Personaje
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiService {
    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: Int): Personaje
}