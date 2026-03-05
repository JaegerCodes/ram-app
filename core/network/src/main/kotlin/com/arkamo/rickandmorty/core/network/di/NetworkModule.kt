package com.arkamo.rickandmorty.core.network.di

import android.app.Application
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single<Moshi> {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single<Cache> {
        val cacheSize = 10 * 1024 * 1024
        Cache(
            directory = get<Application>().cacheDir,
            maxSize = cacheSize.toLong()
        )
    }

    single<OkHttpClient> {
        OkHttpClient()
            .newBuilder()
            .cache(get())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }
}