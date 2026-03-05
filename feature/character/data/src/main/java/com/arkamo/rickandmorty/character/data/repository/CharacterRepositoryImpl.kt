package com.arkamo.rickandmorty.character.data.repository

import com.arkamo.rickandmorty.character.data.dto.CharacterDto
import com.arkamo.rickandmorty.character.data.dto.toDomain
import com.arkamo.rickandmorty.character.data.service.CharacterApiService
import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import com.arkamo.rickandmorty.character.domain.repository.CharacterRepository
import com.arkamo.rickandmorty.core.network.result.apiCall

class CharacterRepositoryImpl(
    private val apiService: CharacterApiService,
) : CharacterRepository {

    override suspend fun getCharacters(): Result<List<Character>> =
        apiCall(
            call = { apiService.getCharacters() },
            onSuccess = { response -> Result.success(response.results.map { it.toDomain() }) },
            onFailure = { error -> Result.failure(Exception(error)) },
        )
}
