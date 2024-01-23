package com.example.pokedexmvvm.dto

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)