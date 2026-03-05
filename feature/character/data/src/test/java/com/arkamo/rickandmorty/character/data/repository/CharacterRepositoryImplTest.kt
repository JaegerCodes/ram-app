package com.arkamo.rickandmorty.character.data.repository

import com.arkamo.rickandmorty.character.data.dto.CharacterDto
import com.arkamo.rickandmorty.character.data.dto.CharacterResponseDto
import com.arkamo.rickandmorty.character.data.service.CharacterApiService
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import retrofit2.Response

class CharacterRepositoryImplTest {

    private val apiService: CharacterApiService = mockk()
    private val repository = CharacterRepositoryImpl(apiService)

    private fun characterDto(
        id: Int = 1,
        name: String = "Rick Sanchez",
        status: String = "Alive",
        species: String = "Human",
        image: String = "https://image.url/rick.jpg",
    ) = CharacterDto(id = id, name = name, status = status, species = species, image = image)

    @Test
    fun `getCharacters returns success with mapped characters when API responds successfully`() = runTest {
        val dtos = listOf(
            characterDto(id = 1, name = "Rick Sanchez", status = "Alive"),
            characterDto(id = 2, name = "Morty Smith", status = "Alive"),
        )
        coEvery { apiService.getCharacters() } returns Response.success(CharacterResponseDto(results = dtos))

        val result = repository.getCharacters()

        assertTrue(result.isSuccess)
        val characters = result.getOrThrow()
        assertEquals(2, characters.size)
        assertEquals(1, characters[0].id)
        assertEquals("Rick Sanchez", characters[0].name)
        assertEquals(CharacterStatus.ALIVE, characters[0].status)
        assertEquals(2, characters[1].id)
        assertEquals("Morty Smith", characters[1].name)
    }

    @Test
    fun `getCharacters returns failure when API responds with error code`() = runTest {
        val mockResponse = mockk<Response<CharacterResponseDto>> {
            coEvery { isSuccessful } returns false
            coEvery { errorBody() } returns null
            coEvery { code() } returns 404
        }
        coEvery { apiService.getCharacters() } returns mockResponse

        val result = repository.getCharacters()

        assertTrue(result.isFailure)
        assertEquals("HTTP 404", result.exceptionOrNull()?.message)
    }

    @Test
    fun `getCharacters returns failure when response body is null`() = runTest {
        coEvery { apiService.getCharacters() } returns Response.success(null)

        val result = repository.getCharacters()

        assertTrue(result.isFailure)
        assertEquals("Empty response body", result.exceptionOrNull()?.message)
    }

    @Test
    fun `getCharacters returns failure when API throws exception`() = runTest {
        coEvery { apiService.getCharacters() } throws RuntimeException("Network error")

        val result = repository.getCharacters()

        assertTrue(result.isFailure)
        assertEquals("Network error", result.exceptionOrNull()?.message)
    }

    @Test
    fun `getCharacters returns empty list when API returns empty results`() = runTest {
        coEvery { apiService.getCharacters() } returns Response.success(CharacterResponseDto(results = emptyList()))

        val result = repository.getCharacters()

        assertTrue(result.isSuccess)
        assertTrue(result.getOrThrow().isEmpty())
    }
}
