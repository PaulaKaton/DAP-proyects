package com.example.trabajoprcticodaplogin_recyclerview.entities

class PokemonRepository {
    private val pokemonList : MutableList<Pokemon> = mutableListOf()

    init {
        pokemonList.add(Pokemon(
            "1",
            "Bulbasaur",
            "Plant",
            "Poison",
            "6.9",
            "0.7",
        ))
        pokemonList.add(Pokemon(
            "2",
            "Ivysaur",
            "Plant",
            "Poison",
            "13.0",
            "1.0",
        ))
        pokemonList.add(Pokemon(
            "3",
            "Venusaur",
            "Plant",
            "Poison",
            "100.0",
            "2.0",
        ))
        pokemonList.add(Pokemon(
            "4",
            "Charmander",
            "Fire",
            "None",
            "8.5",
            "0.6",
        ))
        pokemonList.add(Pokemon(
            "5",
            "Charmeleon",
            "Fire",
            "None",
            "19.0",
            "1.1",
        ))
        pokemonList.add(Pokemon(
            "6",
            "Charizard",
            "Fire",
            "Flying",
            "90.5",
            "1.7",
        ))
        pokemonList.add(Pokemon(
            "7",
            "Squirtle",
            "Water",
            "None",
            "9.0",
            "0.5",
        ))
        pokemonList.add(Pokemon(
            "8",
            "Wartortle",
            "Water",
            "None",
            "22.5",
            "1.0",
        ))
        pokemonList.add(Pokemon(
            "9",
            "Blastoise",
            "Water",
            "None",
            "85.5",
            "1.6",
        ))
    }
    fun getPokemon () : MutableList<Pokemon> {
        return pokemonList
    }
}