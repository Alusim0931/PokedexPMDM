package com.example.pokedexmvvm.di

import com.example.pokedexmvvm.data.repositories.PokemonDetailRepositoryImpl
import com.example.pokedexmvvm.data.sources.local.LocalDataPokemonSource
import com.example.pokedexmvvm.data.sources.remote.PokeApiService
import com.example.pokedexmvvm.data.sources.remote.PokemonRemoteDataSource
import com.example.pokedexmvvm.domain.repositories.IPokemonDetailRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.GsonBuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit): PokeApiService {
        return retrofit.create(PokeApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonDetailRepository(pokemonLocalDataPokemonSource: LocalDataPokemonSource,
                                       pokemonRemoteDataSource: PokemonRemoteDataSource): IPokemonDetailRepository {
        return PokemonDetailRepositoryImpl(pokemonLocalDataPokemonSource,pokemonRemoteDataSource)
    }



}



