package com.arkamo.rickandmorty.character.domain.usecase

import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import com.arkamo.rickandmorty.character.domain.repository.CharacterRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetCharactersUseCaseTest {

    private val repository: CharacterRepository = mockk()
    private val useCase = GetCharactersUseCase(repository)

    private fun character(id: Int = 1, name: String = "Rick Sanchez") = Character(
        id = id,
        name = name,
        status = CharacterStatus.ALIVE,
        species = "Human",
        imageUrl = "https://image.url/$id.jpg",
    )

    @Test
    fun `invoke returns success result from repository`() = runTest {
        val characters = listOf(character(1, "Rick Sanchez"), character(2, "Morty Smith"))
        coEvery { repository.getCharacters() } returns Result.success(characters)

        val result = useCase()

        assertTrue(result.isSuccess)
        assertEquals(characters, result.getOrThrow())
    }

    @Test
    fun `invoke returns failure result from repository`() = runTest {
        val error = Exception("Network error")
        coEvery { repository.getCharacters() } returns Result.failure(error)

        val result = useCase()

        assertTrue(result.isFailure)
        assertEquals("Network error", result.exceptionOrNull()?.message)
    }

    @Test
    fun `invoke delegates to repository exactly once`() = runTest {
        coEvery { repository.getCharacters() } returns Result.success(emptyList())

        useCase()

        coVerify(exactly = 1) { repository.getCharacters() }
    }

    @Test
    fun `invoke returns empty list when repository returns empty results`() = runTest {
        coEvery { repository.getCharacters() } returns Result.success(emptyList())

        val result = useCase()

        assertTrue(result.isSuccess)
        assertTrue(result.getOrThrow().isEmpty())
    }
}
