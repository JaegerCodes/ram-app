package com.arkamo.rickandmorty.app

import android.app.Application
import com.arkamo.rickandmorty.character.data.di.characterDataModule
import com.arkamo.rickandmorty.character.domain.di.characterDomainModule
import com.arkamo.rickandmorty.character.presentation.di.characterPresentationModule
import com.arkamo.rickandmorty.core.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    characterDomainModule,
                    characterDataModule,
                    characterPresentationModule,
                )
            )
        }
    }
}
