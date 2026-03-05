package com.arkamo.rickandmorty.character.presentation.di

import com.arkamo.rickandmorty.character.presentation.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterPresentationModule = module {
    viewModel { CharacterViewModel(get()) }
}
