package com.example.pokemon.controller

import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.Type
import com.example.pokemon.model.TypeName
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException
import org.springframework.web.server.ResponseStatusException
import java.net.http.HttpResponse

@RestController
@RequestMapping("/pokemon")
class PokedexController {
    val pokemonList = mutableListOf(
        Pokemon(1, "Bulbizarre", "Un Pokemon bulbe vivant dans les champs", 1, Type(TypeName.Grass, TypeName.Poison)),
        Pokemon(152, "Germignon", "Un petit germe trop mignon", 2, Type(TypeName.Grass)),
        Pokemon(494, "Victini", "Une victoire a portee de main", 5, Type(TypeName.Fire, TypeName.Psychic)),
    )

    @GetMapping
    fun getAllPokemon(): ResponseEntity<List<Pokemon>> {
        return ResponseEntity.ok().body(pokemonList)
    }


    @GetMapping("/id/{id}")
    fun getPokemonById(
        @PathVariable id: Int
    ): ResponseEntity<Pokemon> {
        val pokemon = pokemonList.find { it.id == id }
        if (pokemon != null) {
            return ResponseEntity.ok().body(pokemon)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/generation/{generation}")
    fun getPokemonByGeneration(
        @PathVariable generation: Int
    ): List<Pokemon> {
        return pokemonList.filter { it.generation == generation }
    }

    @PostMapping
    fun createPokemon(
        @RequestBody pokemon: Pokemon
    ): ResponseEntity<Pokemon> {
        if (pokemonList.find { it.id == pokemon.id } != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "the Pokemon already exists")
        }
        pokemonList.add(pokemon)
        return ResponseEntity(pokemon, HttpStatus.CREATED)
    }

    @PatchMapping("/description/{id}")
    fun editDescription(
        @PathVariable id: Int,
        @RequestBody description: String
    ): ResponseEntity<Pokemon> {
        val pokemonToUpdate = pokemonList.find { it.id == id }
        if (pokemonToUpdate == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon with id: $id not found, update impossible")
        }
        val updatedPokemon = pokemonToUpdate.copy(description = description)
        pokemonList.removeIf { it.id == id }
        pokemonList.add(updatedPokemon)
        return ResponseEntity.ok().body(updatedPokemon)
    }

    @DeleteMapping("/{id}")
    fun deletePokemon(
        @PathVariable id: Int
    ): ResponseEntity.HeadersBuilder<*> {
        pokemonList.removeIf { it.id == id }
        return ResponseEntity.noContent()
    }
}