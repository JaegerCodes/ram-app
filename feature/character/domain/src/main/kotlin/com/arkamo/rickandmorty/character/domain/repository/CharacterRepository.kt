package com.arkamo.rickandmorty.character.domain.repository

import com.arkamo.rickandmorty.character.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): Result<List<Character>>
}
