package com.example.pokemon.controller

import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.Type
import com.example.pokemon.model.TypeName
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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
    val pokemonList = listOf(
        Pokemon(1, "Bulbizarre", "Un Pokemon bulbe vivant dans les champs", 1, Type(TypeName.Grass, TypeName.Poison)),
        Pokemon(152, "Germignon", "Un petit germe trop mignon", 2, Type(TypeName.Grass)),
        Pokemon(494, "Victini", "Une victoire a portee de main", 5, Type(TypeName.Fire, TypeName.Psychic)),
    )

    @GetMapping
    fun getAllPokemon(): ResponseEntity<List<Pokemon>> {
        return ResponseEntity.ok().body(pokemonList)
    }

    /**
     * Uncomment the following as you progress through the TD
     *
     *
    @GetMapping
    fun getPokemonById(
        @RequestParam("id") id: Int
    ): Pokemon {
//TODO
    }


    @PostMapping
    fun createPokemon(
        @RequestBody pokemon: Pokemon
    ): Unit {
        //TODO
    }
    */
}