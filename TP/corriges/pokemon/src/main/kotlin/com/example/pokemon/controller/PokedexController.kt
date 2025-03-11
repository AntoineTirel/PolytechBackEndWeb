package com.example.pokemon.controller

import com.example.pokemon.model.PokemonDTO
import com.example.pokemon.model.Type
import com.example.pokemon.model.TypeName
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
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/pokemon")
class PokedexController(
    private val pokemonService: PokemonService,
) {
    val pokemonDTOLists = mutableListOf(
        PokemonDTO(
            1,
            "Bulbizarre",
            "Un Pokemon bulbe vivant dans les champs",
            1,
            Type(TypeName.Grass, TypeName.Poison)
        ),
        PokemonDTO(152, "Germignon", "Un petit germe trop mignon", 2, Type(TypeName.Grass)),
        PokemonDTO(494, "Victini", "Une victoire a portee de main", 5, Type(TypeName.Fire, TypeName.Psychic)),
    )

    @GetMapping
    fun getAllPokemon(): ResponseEntity<List<PokemonDTO>> {
        return ResponseEntity.ok()
            .body(pokemonService.getAllPokemon())
    }


    @GetMapping("/id/{id}")
    fun getPokemonById(
        @PathVariable id: Long
    ): ResponseEntity<PokemonDTO> {
        val pokemon = pokemonDTOLists.find { it.id == id }
        if (pokemon != null) {
            return ResponseEntity.ok().body(pokemon)
        }
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/generation/{generation}")
    fun getPokemonByGeneration(
        @PathVariable generation: Int
    ): List<PokemonDTO> {
        return pokemonDTOLists.filter { it.generation == generation }
    }

    @PostMapping
    fun createPokemon(
        @RequestBody pokemonDTO: PokemonDTO
    ): ResponseEntity<PokemonDTO> {
        if (pokemonDTOLists.find { it.id == pokemonDTO.id } != null) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "the Pokemon already exists")
        }
        pokemonDTOLists.add(pokemonDTO)
        return ResponseEntity(pokemonDTO, HttpStatus.CREATED)
    }

    @PatchMapping("/description/{id}")
    fun editDescription(
        @PathVariable id: Long,
        @RequestBody description: String
    ): ResponseEntity<PokemonDTO> {
        val pokemonToUpdate = pokemonDTOLists.find { it.id == id }
        if (pokemonToUpdate == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon with id: $id not found, update impossible")
        }
        val updatedPokemon = pokemonToUpdate.copy(description = description)
        pokemonDTOLists.removeIf { it.id == id }
        pokemonDTOLists.add(updatedPokemon)
        return ResponseEntity.ok().body(updatedPokemon)
    }

    @DeleteMapping("/{id}")
    fun deletePokemon(
        @PathVariable id: Long
    ): ResponseEntity.HeadersBuilder<*> {
        pokemonDTOLists.removeIf { it.id == id }
        return ResponseEntity.noContent()
    }
}