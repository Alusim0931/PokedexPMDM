package com.example.pokedexmvvm.dto

import com.example.pokedexmvvm.dto.GenerationI
import com.example.pokedexmvvm.dto.GenerationIi
import com.example.pokedexmvvm.dto.GenerationIii
import com.example.pokedexmvvm.dto.GenerationIv
import com.example.pokedexmvvm.dto.GenerationV
import com.example.pokedexmvvm.dto.GenerationVi
import com.example.pokedexmvvm.dto.GenerationVii
import com.example.pokedexmvvm.dto.GenerationViii

data class Versions(
    val generation_i: GenerationI,
    val generation_ii: GenerationIi,
    val generation_iii: GenerationIii,
    val generation_iv: GenerationIv,
    val generation_v: GenerationV,
    val generation_vi: GenerationVi,
    val generation_vii: GenerationVii,
    val generation_viii: GenerationViii
)