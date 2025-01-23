package com.example.pokemon.model

enum class TypeName {
    Normal,
    Fighting,
    Flying,
    Poison,
    Ground,
    Rock,
    Bug,
    Ghost,
    Steel,
    Fire,
    Water,
    Grass,
    Electric,
    Psychic,
    Ice,
    Dragon,
    Dark,
    Fairy
}

class Type(
    val name1: TypeName,
    val name2: TypeName? = null,
    val weaknesses: ArrayList<TypeName> = arrayListOf(),
    val resistances: ArrayList<TypeName> = arrayListOf()
)
