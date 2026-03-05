package com.arkamo.rickandmorty.character.presentation.mvi

/**
 * Represents every action the user can trigger from the character screen.
 * In MVI, Intents are the single source of input to the ViewModel.
 */
sealed class CharacterIntent {
    data object LoadCharacters : CharacterIntent()
    data object Retry : CharacterIntent()
}
