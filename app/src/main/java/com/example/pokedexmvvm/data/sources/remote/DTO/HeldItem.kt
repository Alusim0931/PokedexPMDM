package com.example.pokedexmvvm.data.sources.remote.DTO

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)