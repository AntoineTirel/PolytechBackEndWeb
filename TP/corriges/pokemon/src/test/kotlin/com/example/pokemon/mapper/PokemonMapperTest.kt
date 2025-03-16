package com.example.pokemon.mapper

import com.example.pokemon.entity.Pokemon
import com.example.pokemon.entity.TypeEntity
import com.example.pokemon.mappers.PokemonMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class PokemonMapperTest {

    private lateinit var pokemonEntity: Pokemon
    private lateinit var type1: TypeEntity
    private lateinit var type2: TypeEntity

    private val classUnderTest = PokemonMapper()

    @BeforeEach
    fun setUp() {
        // Mocking TypeEntity instances
        type1 = TypeEntity(
            id = 1L,
            typeName = "Fire"
        )
        type2 = TypeEntity(
            id = 2L,
            typeName = "Flying"
        )

        // Mocking a Pokemon entity
        pokemonEntity = Pokemon(
            id = 6L,
            name = "Charizard",
            description = "Un dragon tro kool ki crash du FE",
            generation = 1,
            type1 = type1,
            type2 = type2,
            weaknesses = HashSet()
        )
    }

    @Test
    fun `should map PokemonEntity to PokemonDTO correctly`() {
        // Act
        val result = classUnderTest.pokemonEntityToPokemonDTO(pokemonEntity)

        // Assert
        assertNotNull(result)
        assertEquals(pokemonEntity.id, result.id)
        assertEquals(pokemonEntity.name, result.name)
        assertEquals(pokemonEntity.description, result.description)
        assertEquals(pokemonEntity.generation, result.generation)
        assertNotNull(result.type)
        assertTrue { result.type.name1.name == "Fire" }
        assertTrue(result.type.name2?.name == "Flying")
    }

    @Test
    fun `should handle missing second type`() {
        // Arrange
        val pokemonEntityWithOneType = Pokemon(
            id = 101L,
            name = "Charmander",
            description = "A small fire Pokémon",
            generation = 1,
            type1 = type1,
            type2 = null, // Missing second type,
            weaknesses = hashSetOf()
        )

        // Act
        val result = classUnderTest.pokemonEntityToPokemonDTO(pokemonEntityWithOneType)

        // Assert
        assertNotNull(result)
        assertEquals(pokemonEntityWithOneType.id, result.id)
        assertEquals(pokemonEntityWithOneType.name, result.name)
        assertEquals(pokemonEntityWithOneType.description, result.description)
        assertEquals(pokemonEntityWithOneType.generation, result.generation)
        assertNotNull(result.type)
    }
}
