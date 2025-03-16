package com.example.pokemon.repository

import com.example.pokemon.entity.Pokemon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface PokemonRepository : JpaRepository<Pokemon, Long> {
    fun findByGeneration(generation: Long): List<Pokemon>

    @Modifying(clearAutomatically = true)
    @Query("update Pokemon p set p.description = ?1 where p.id = ?2")
    fun updateDescription(newDescription: String, pokemonId: Long): Pokemon
}