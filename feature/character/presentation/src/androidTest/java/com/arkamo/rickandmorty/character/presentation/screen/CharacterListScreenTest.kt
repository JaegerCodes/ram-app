package com.arkamo.rickandmorty.character.presentation.screen

import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasProgressBarRangeInfo
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import com.arkamo.rickandmorty.character.presentation.mvi.CharacterIntent
import com.arkamo.rickandmorty.character.presentation.mvi.CharacterUiState
import com.arkamo.rickandmorty.character.presentation.viewmodel.CharacterViewModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun character(
        id: Int = 1,
        name: String = "Rick Sanchez",
        status: CharacterStatus = CharacterStatus.ALIVE,
        species: String = "Human",
    ) = Character(id = id, name = name, status = status, species = species, imageUrl = "https://image.url/$id.jpg")

    private fun viewModelWith(state: CharacterUiState): CharacterViewModel =
        mockk(relaxed = true) {
            every { uiState } returns MutableStateFlow(state)
        }

    @Test
    fun topAppBar_alwaysShowsTitle() {
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(CharacterUiState.Loading))
        }
        composeTestRule.onNodeWithText("Rick & Morty").assertIsDisplayed()
    }

    @Test
    fun loadingState_showsProgressIndicator() {
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(CharacterUiState.Loading))
        }
        composeTestRule
            .onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
            .assertIsDisplayed()
    }

    @Test
    fun loadingState_doesNotShowErrorContent() {
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(CharacterUiState.Loading))
        }
        composeTestRule.onNodeWithText("Something went wrong").assertDoesNotExist()
    }

    @Test
    fun successState_showsCharacterName() {
        val state = CharacterUiState.Success(listOf(character(name = "Rick Sanchez")))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Rick Sanchez").assertIsDisplayed()
    }

    @Test
    fun successState_showsCharacterSpecies() {
        val state = CharacterUiState.Success(listOf(character(species = "Alien")))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Alien").assertIsDisplayed()
    }

    @Test
    fun successState_showsAliveStatusBadge() {
        val state = CharacterUiState.Success(listOf(character(status = CharacterStatus.ALIVE)))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Alive").assertIsDisplayed()
    }

    @Test
    fun successState_showsDeadStatusBadge() {
        val state = CharacterUiState.Success(listOf(character(status = CharacterStatus.DEAD)))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Dead").assertIsDisplayed()
    }

    @Test
    fun successState_showsUnknownStatusBadge() {
        val state = CharacterUiState.Success(listOf(character(status = CharacterStatus.UNKNOWN)))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Unknown").assertIsDisplayed()
    }

    @Test
    fun successState_showsImageContentDescription() {
        val state = CharacterUiState.Success(listOf(character(name = "Morty Smith")))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule
            .onNodeWithContentDescription("Avatar of Morty Smith")
            .assertIsDisplayed()
    }

    @Test
    fun successState_showsMultipleCharacters() {
        val state = CharacterUiState.Success(
            characters = listOf(
                character(id = 1, name = "Rick Sanchez"),
                character(id = 2, name = "Morty Smith"),
                character(id = 3, name = "Beth Smith"),
            ),
        )
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Rick Sanchez").assertIsDisplayed()
        composeTestRule.onNodeWithText("Morty Smith").assertIsDisplayed()
        composeTestRule.onNodeWithText("Beth Smith").assertIsDisplayed()
    }

    @Test
    fun successState_doesNotShowErrorContent() {
        val state = CharacterUiState.Success(listOf(character()))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Something went wrong").assertDoesNotExist()
    }

    @Test
    fun errorState_showsErrorTitle() {
        val state = CharacterUiState.Error("Network error")
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Something went wrong").assertIsDisplayed()
    }

    @Test
    fun errorState_showsErrorMessage() {
        val state = CharacterUiState.Error("No internet connection")
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("No internet connection").assertIsDisplayed()
    }

    @Test
    fun errorState_showsRetryButton() {
        val state = CharacterUiState.Error("Network error")
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule.onNodeWithText("Retry").assertIsDisplayed()
    }

    @Test
    fun errorState_clickRetry_triggersRetryIntent() {
        val viewModel = viewModelWith(CharacterUiState.Error("Network error"))
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModel)
        }

        composeTestRule.onNodeWithText("Retry").performClick()

        verify { viewModel.handleIntent(CharacterIntent.Retry) }
    }

    @Test
    fun errorState_doesNotShowProgressIndicator() {
        val state = CharacterUiState.Error("Network error")
        composeTestRule.setContent {
            CharacterListScreen(viewModel = viewModelWith(state))
        }
        composeTestRule
            .onNode(hasProgressBarRangeInfo(ProgressBarRangeInfo.Indeterminate))
            .assertDoesNotExist()
    }
}
