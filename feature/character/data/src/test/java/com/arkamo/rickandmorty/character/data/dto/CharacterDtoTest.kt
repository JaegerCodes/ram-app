package com.arkamo.rickandmorty.character.data.dto

import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterDtoTest {

    private fun dto(
        id: Int = 1,
        name: String = "Rick Sanchez",
        status: String = "Alive",
        species: String = "Human",
        image: String = "https://image.url/rick.jpg",
    ) = CharacterDto(id = id, name = name, status = status, species = species, image = image)

    @Test
    fun `toDomain maps all fields correctly`() {
        val dto = dto(id = 42, name = "Morty Smith", status = "alive", species = "Human", image = "https://url.jpg")
        val character = dto.toDomain()

        assertEquals(42, character.id)
        assertEquals("Morty Smith", character.name)
        assertEquals(CharacterStatus.ALIVE, character.status)
        assertEquals("Human", character.species)
        assertEquals("https://url.jpg", character.imageUrl)
    }

    @Test
    fun `toDomain maps alive status case-insensitively`() {
        assertEquals(CharacterStatus.ALIVE, dto(status = "alive").toDomain().status)
        assertEquals(CharacterStatus.ALIVE, dto(status = "Alive").toDomain().status)
        assertEquals(CharacterStatus.ALIVE, dto(status = "ALIVE").toDomain().status)
    }

    @Test
    fun `toDomain maps dead status case-insensitively`() {
        assertEquals(CharacterStatus.DEAD, dto(status = "dead").toDomain().status)
        assertEquals(CharacterStatus.DEAD, dto(status = "Dead").toDomain().status)
        assertEquals(CharacterStatus.DEAD, dto(status = "DEAD").toDomain().status)
    }

    @Test
    fun `toDomain maps unknown status for unrecognized values`() {
        assertEquals(CharacterStatus.UNKNOWN, dto(status = "unknown").toDomain().status)
        assertEquals(CharacterStatus.UNKNOWN, dto(status = "Unknown").toDomain().status)
        assertEquals(CharacterStatus.UNKNOWN, dto(status = "").toDomain().status)
        assertEquals(CharacterStatus.UNKNOWN, dto(status = "zombie").toDomain().status)
    }
}
