package com.arkamo.rickandmorty.character.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arkamo.rickandmorty.character.domain.usecase.GetCharactersUseCase
import com.arkamo.rickandmorty.character.presentation.mvi.CharacterIntent
import com.arkamo.rickandmorty.character.presentation.mvi.CharacterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * MVI ViewModel for the character list screen.
 *
 * - Receives [CharacterIntent]s via [handleIntent].
 * - Exposes a single [StateFlow] of [CharacterUiState] to the UI.
 * - The UI is purely reactive: it only renders the current state.
 */
class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()

    init {
        handleIntent(CharacterIntent.LoadCharacters)
    }

    fun handleIntent(intent: CharacterIntent) {
        when (intent) {
            CharacterIntent.LoadCharacters,
            CharacterIntent.Retry -> loadCharacters()
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _uiState.value = CharacterUiState.Loading
            getCharactersUseCase()
                .onSuccess { characters ->
                    _uiState.value = CharacterUiState.Success(characters)
                }
                .onFailure { error ->
                    _uiState.value = CharacterUiState.Error(
                        message = error.message ?: "Unexpected error. Please try again.",
                    )
                }
        }
    }
}
