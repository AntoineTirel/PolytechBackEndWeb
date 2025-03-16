package com.example.pokemon.service

import com.example.pokemon.mappers.PokemonMapper
import com.example.pokemon.model.PokemonDTO
import com.example.pokemon.repository.PokemonRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class PokemonService(
    private val pokemonRepository: PokemonRepository,
    private val pokemonMapper: PokemonMapper
) {
    fun getAllPokemon(): List<PokemonDTO> =
        pokemonRepository.findAll().map { pokemonMapper.pokemonEntityToPokemonDTO(it) }

    fun getPokemonById(id: Long): PokemonDTO? {
        val optionalPokemon = pokemonRepository.findById(id)
        if (optionalPokemon.isPresent) {
            return pokemonMapper.pokemonEntityToPokemonDTO(optionalPokemon.get())
        }
        return null
    }

    fun getAllPokemonByGeneration(generation: Long): List<PokemonDTO> =
        pokemonRepository.findByGeneration(generation).map { pokemonMapper.pokemonEntityToPokemonDTO(it) }

    fun createPokemon(pokemonDTO: PokemonDTO): PokemonDTO {
        val pokemonInRepository = pokemonRepository.findById(pokemonDTO.id)
        if (pokemonInRepository.isPresent) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "the Pokemon already exists")
        } else {
            val createdPokemon = pokemonRepository.save(pokemonMapper.pokemonDTOToPokemonEntity(pokemonDTO))
            return pokemonMapper.pokemonEntityToPokemonDTO(createdPokemon)
        }
    }

    fun updateDescription(pokemonId: Long, newDescription: String): PokemonDTO {
        val pokemonToUpdate = pokemonRepository.findById(pokemonId)
        if (pokemonToUpdate.isPresent) {
            val updatedEntity = pokemonRepository.updateDescription(newDescription, pokemonId)
            return pokemonMapper.pokemonEntityToPokemonDTO(updatedEntity)
        } else {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Pokemon with id: $pokemonId not found, update impossible"
            )
        }
    }

    fun deletePokemonById(pokemonId: Long) {
        pokemonRepository.deleteById(pokemonId)
    }
}