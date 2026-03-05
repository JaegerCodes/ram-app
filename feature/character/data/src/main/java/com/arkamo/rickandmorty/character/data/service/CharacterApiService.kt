package com.arkamo.rickandmorty.character.data.service

import com.arkamo.rickandmorty.character.data.dto.CharacterResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponseDto>
}
