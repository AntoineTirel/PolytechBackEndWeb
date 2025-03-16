package com.example.pokemon.mappers

import com.example.pokemon.entity.Pokemon
import com.example.pokemon.entity.TypeEntity
import com.example.pokemon.model.PokemonDTO
import com.example.pokemon.model.Type
import com.example.pokemon.model.TypeName
import org.springframework.stereotype.Service

@Service
class PokemonMapper {
    fun pokemonEntityToPokemonDTO(pokemonEntity: Pokemon): PokemonDTO {
        return PokemonDTO(
            id = pokemonEntity.id,
            name = pokemonEntity.name,
            description = pokemonEntity.description,
            generation = pokemonEntity.generation,
            type = typeEntityToTypeDTO(pokemonEntity.type1, pokemonEntity.type2),
        )
    }

    fun pokemonDTOToPokemonEntity(pokemonDTO: PokemonDTO): Pokemon {
        return Pokemon(
            id = pokemonDTO.id,
            name = pokemonDTO.name,
            description = pokemonDTO.description,
            generation = pokemonDTO.generation,
            type1 = TypeEntity(null, pokemonDTO.type.name1.toString()),
            type2 = TypeEntity(null, pokemonDTO.type.name2.toString()),
            weaknesses = setOf()
        )
    }

    private fun typeEntityToTypeDTO(type1: TypeEntity, type2: TypeEntity?): Type {
        val type2Name = if (type2 != null) {
            TypeName.valueOf(type2.typeName)
        } else {
            null
        }
        return Type(
            TypeName.valueOf(type1.typeName),
            type2Name,
            weaknesses = arrayListOf(),
            resistances = arrayListOf()
        )
    }
}