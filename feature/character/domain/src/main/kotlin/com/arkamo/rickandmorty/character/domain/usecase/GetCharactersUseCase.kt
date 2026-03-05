package com.arkamo.rickandmorty.character.domain.usecase

import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.repository.CharacterRepository

class GetCharactersUseCase(
    private val repository: CharacterRepository,
) {
    suspend operator fun invoke(): Result<List<Character>> = repository.getCharacters()
}
