package com.arkamo.rickandmorty.character.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.arkamo.rickandmorty.character.presentation.screen.CharacterListScreen

const val CHARACTER_LIST_ROUTE = "character_list"

fun NavGraphBuilder.characterListScreen() {
    composable(route = CHARACTER_LIST_ROUTE) {
        CharacterListScreen()
    }
}
