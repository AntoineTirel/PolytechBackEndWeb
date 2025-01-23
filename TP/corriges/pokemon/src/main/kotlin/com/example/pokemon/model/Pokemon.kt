package com.example.pokemon.model

data class Pokemon(
    val id: Int,
    val name: String,
    val description: String,
    val generation: Int,
    val type: Type
)
