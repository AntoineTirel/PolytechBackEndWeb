package com.example.pokemon.mappers

import com.example.pokemon.entity.Pokemon
import com.example.pokemon.model.PokemonDTO

class PokemonMapper {
    fun pokemonEntityToPokemonDTO(pokemonEntity: Pokemon): PokemonDTO {
        return PokemonDTO(
            id = pokemonEntity.id,
            name = pokemonEntity.name,
            description = pokemonEntity.description,
            generation = pokemonEntity.generation,
            type = pokemonEntity.type,
        )
    }
}