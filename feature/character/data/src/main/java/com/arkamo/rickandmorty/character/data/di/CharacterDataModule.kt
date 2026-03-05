package com.arkamo.rickandmorty.character.data.di

import com.arkamo.rickandmorty.character.data.repository.CharacterRepositoryImpl
import com.arkamo.rickandmorty.character.data.service.CharacterApiService
import com.arkamo.rickandmorty.character.domain.repository.CharacterRepository
import org.koin.dsl.module
import retrofit2.Retrofit

val characterDataModule = module {
    single<CharacterApiService> {
        get<Retrofit>().create(CharacterApiService::class.java)
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }
}
