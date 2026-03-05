package com.arkamo.rickandmorty.character.domain.di

import com.arkamo.rickandmorty.character.domain.usecase.GetCharactersUseCase
import org.koin.dsl.module

val characterDomainModule = module {
    factory { GetCharactersUseCase(get()) }
}
