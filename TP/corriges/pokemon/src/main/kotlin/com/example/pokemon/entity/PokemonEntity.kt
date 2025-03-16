package com.example.pokemon.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "pokemon")
data class Pokemon(
    @Id
    // @GeneratedValue(strategy =GenerationType.IDENTITY )
    // FIXME Generated Value does not allow to save Pokemon with id with hibernate
    val id: Long,
    val name: String,
    val description: String,
    val generation: Int,
    @ManyToOne
    @JoinColumn(name = "type1", referencedColumnName = "typeName")
    val type1: TypeEntity,
    @ManyToOne
    @JoinColumn(name = "type2", referencedColumnName = "typeName")
    val type2: TypeEntity?,
    @ManyToMany
    @JoinTable(
        name = "pokemon_weakness",
        joinColumns = [JoinColumn(name = "pokemon_id")],
        inverseJoinColumns = [JoinColumn(name = "type_id")]
    )
    val weaknesses: Set<TypeEntity>,
)