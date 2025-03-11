package com.example.pokemon.service

import com.example.pokemon.mappers.PokemonMapper
import com.example.pokemon.model.PokemonDTO
import com.example.pokemon.repository.PokemonRepository
import org.springframework.stereotype.Service

@Service
class PokemonService(
    private val pokemonRepository: PokemonRepository,
    private val pokemonMapper: PokemonMapper
) {
    fun getAllPokemon(): List<PokemonDTO> =
        pokemonRepository.findAll().map { pokemonMapper.pokemonEntityToPokemonDTO(it) }

}