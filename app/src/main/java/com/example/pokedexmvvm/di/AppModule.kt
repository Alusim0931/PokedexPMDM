package com.example.pokedexmvvm.di

import android.app.Application
import android.content.Context
import com.example.pokedexmvvm.dto.Pokemon
import com.example.pokedexmvvm.viewmodel.PokemonViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providePokemon(application: Application): Pokemon {
        val context: Context = application.applicationContext
        val pokemon: Pokemon = getPokemonJson("ditto.json",context)
        return pokemon
    }
    @Provides
        @Singleton
    fun providePokemonViewModel(application: Application, pokemon: Pokemon): PokemonViewModel {
        return PokemonViewModel(application, pokemon)
    }

}*/