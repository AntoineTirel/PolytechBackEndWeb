package com.example.pokemon.controller

import com.example.pokemon.model.PokemonDTO
import com.example.pokemon.service.PokemonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemon")
class PokedexController(
    private val pokemonService: PokemonService,
) {

    @GetMapping
    fun getAllPokemon(): ResponseEntity<List<PokemonDTO>> {
        return ResponseEntity.ok()
            .body(pokemonService.getAllPokemon())
    }

    @GetMapping("/id/{id}")
    fun getPokemonById(
        @PathVariable id: Long
    ): ResponseEntity<PokemonDTO> {
        return ResponseEntity.ok().body(pokemonService.getPokemonById(id))
    }

    @GetMapping("/generation/{generation}")
    fun getPokemonByGeneration(
        @PathVariable generation: Int
    ): ResponseEntity<List<PokemonDTO>> {
        return ResponseEntity.ok().body(pokemonService.getAllPokemonByGeneration(generation.toLong()))
    }

    @PostMapping
    fun createPokemon(
        @RequestBody pokemonDTO: PokemonDTO
    ): ResponseEntity<PokemonDTO> {
        val pokemonCreated = pokemonService.createPokemon(pokemonDTO)
        return ResponseEntity(pokemonCreated, HttpStatus.CREATED)
    }

    @PatchMapping("/description/{id}")
    fun editDescription(
        @PathVariable id: Long,
        @RequestBody description: String
    ): ResponseEntity<PokemonDTO> {
        val updatedPokemon = pokemonService.updateDescription(id, description)
        return ResponseEntity.ok().body(updatedPokemon)
    }

    @DeleteMapping("/{id}")
    fun deletePokemon(
        @PathVariable id: Long
    ): ResponseEntity.HeadersBuilder<*> {
        pokemonService.deletePokemonById(id)
        return ResponseEntity.noContent()
    }
}