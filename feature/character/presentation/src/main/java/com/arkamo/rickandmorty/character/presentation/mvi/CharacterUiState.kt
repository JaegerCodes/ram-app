package com.arkamo.rickandmorty.character.presentation.mvi

import com.arkamo.rickandmorty.character.domain.model.Character

/**
 * Represents every possible UI state for the character list screen.
 * The UI should only render; all logic lives in the ViewModel.
 */
sealed class CharacterUiState {
    data object Loading : CharacterUiState()

    data class Success(
        val characters: List<Character>,
    ) : CharacterUiState()

    data class Error(
        val message: String,
    ) : CharacterUiState()
}
