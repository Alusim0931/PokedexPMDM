package com.example.pokedexmvvm.di

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