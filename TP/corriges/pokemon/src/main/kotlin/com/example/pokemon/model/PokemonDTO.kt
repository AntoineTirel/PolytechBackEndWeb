package com.example.pokemon.model

data class PokemonDTO(
    val id: Long,
    val name: String,
    val description: String,
    val generation: Int,
    val type: Type
)
