package com.arkamo.rickandmorty.character.data.dto

import com.arkamo.rickandmorty.character.domain.model.Character
import com.arkamo.rickandmorty.character.domain.model.CharacterStatus
import com.squareup.moshi.Json

data class CharacterResponseDto(
    @Json(name = "results") val results: List<CharacterDto>,
)

data class CharacterDto(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "status") val status: String,
    @Json(name = "species") val species: String,
    @Json(name = "image") val image: String,
)



fun CharacterDto.toDomain() = Character(
    id = id,
    name = name,
    status = when (status.lowercase()) {
        "alive" -> CharacterStatus.ALIVE
        "dead" -> CharacterStatus.DEAD
        else -> CharacterStatus.UNKNOWN
    },
    species = species,
    imageUrl = image,
)