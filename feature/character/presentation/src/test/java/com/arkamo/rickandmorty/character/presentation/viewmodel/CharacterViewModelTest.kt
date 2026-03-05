package com.arkamo.rickandmorty.character.presentation.viewmodel

import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import com.arkamo.rickandmorty.character.domain.usecase.GetCharactersUseCase
import com.arkamo.rickandmorty.character.presentation.mvi.CharacterIntent
import com.arkamo.rickandmorty.character.presentation.mvi.CharacterUiState
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterViewModelTest {

    private val getCharactersUseCase: GetCharactersUseCase = mockk()

    private fun character(id: Int = 1, name: String = "Rick Sanchez") = Character(
        id = id,
        name = name,
        status = CharacterStatus.ALIVE,
        species = "Human",
        imageUrl = "https://image.url/$id.jpg",
    )

    @Test
    fun `initial state is Loading before use case completes`() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)

        coEvery { getCharactersUseCase() } coAnswers {
            delay(100)
            Result.success(emptyList())
        }

        val viewModel = CharacterViewModel(getCharactersUseCase)

        assertEquals(CharacterUiState.Loading, viewModel.uiState.value)

        advanceUntilIdle()
        Dispatchers.resetMain()
    }

    @Test
    fun `init loads characters and emits Success state`() = runTest {
        Dispatchers.setMain(UnconfinedTestDispatcher(testScheduler))
        val characters = listOf(character(1), character(2))
        coEvery { getCharactersUseCase() } returns Result.success(characters)

        val viewModel = CharacterViewModel(getCharactersUseCase)

        assertEquals(CharacterUiState.Success(characters), viewModel.uiState.value)
        Dispatchers.resetMain()
    }

    @Test
    fun `init loads characters and emits Error state on failure`() = runTest {
        Dispatchers.setMain(UnconfinedTestDispatcher(testScheduler))
        coEvery { getCharactersUseCase() } returns Result.failure(Exception("Network error"))

        val viewModel = CharacterViewModel(getCharactersUseCase)

        val state = viewModel.uiState.value
        assertTrue(state is CharacterUiState.Error)
        assertEquals("Network error", (state as CharacterUiState.Error).message)
        Dispatchers.resetMain()
    }

    @Test
    fun `init uses fallback message when exception has no message`() = runTest {
        Dispatchers.setMain(UnconfinedTestDispatcher(testScheduler))
        coEvery { getCharactersUseCase() } returns Result.failure(Exception())

        val viewModel = CharacterViewModel(getCharactersUseCase)

        val state = viewModel.uiState.value as CharacterUiState.Error
        assertEquals("Unexpected error. Please try again.", state.message)
        Dispatchers.resetMain()
    }

    @Test
    fun `LoadCharacters intent resets to Loading then emits Success`() = runTest {
        val dispatcher = StandardTestDispatcher(testScheduler)
        Dispatchers.setMain(dispatcher)
        val characters = listOf(character())
        coEvery { getCharactersUseCase() } returns Result.success(characters)

        val viewModel = CharacterViewModel(getCharactersUseCase)
        advanceUntilIdle()

        viewModel.handleIntent(CharacterIntent.LoadCharacters)
        assertEquals(CharacterUiState.Loading, viewModel.uiState.value)

        advanceUntilIdle()
        assertEquals(CharacterUiState.Success(characters), viewModel.uiState.value)
        Dispatchers.resetMain()
    }


    @Test
    fun `Retry intent reloads characters after an error`() = runTest {
        Dispatchers.setMain(UnconfinedTestDispatcher(testScheduler))
        val characters = listOf(character())
        coEvery { getCharactersUseCase() } returnsMany listOf(
            Result.failure(Exception("Network error")),
            Result.success(characters),
        )

        val viewModel = CharacterViewModel(getCharactersUseCase)
        assertTrue(viewModel.uiState.value is CharacterUiState.Error)

        viewModel.handleIntent(CharacterIntent.Retry)

        assertEquals(CharacterUiState.Success(characters), viewModel.uiState.value)
        Dispatchers.resetMain()
    }

    @Test
    fun `Retry intent calls use case twice in total`() = runTest {
        Dispatchers.setMain(UnconfinedTestDispatcher(testScheduler))
        coEvery { getCharactersUseCase() } returns Result.success(emptyList())

        val viewModel = CharacterViewModel(getCharactersUseCase)
        viewModel.handleIntent(CharacterIntent.Retry)

        coVerify(exactly = 2) { getCharactersUseCase() }
        Dispatchers.resetMain()
    }
}
