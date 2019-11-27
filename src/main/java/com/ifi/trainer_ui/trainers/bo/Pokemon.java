package com.ifi.trainer_ui.trainers.bo;

import com.ifi.trainer_ui.pokemonTypes.bo.PokemonType;

public class Pokemon {

    public Pokemon() {
    }

    public Pokemon(int pokemonType, int level) {
        this.pokemonType = pokemonType;
        this.level = level;
    }

    private int pokemonType;

    private int level;

    private PokemonType pokemonTypeDetails;

    public int getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(int pokemonType) {
        this.pokemonType = pokemonType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPokemonType(PokemonType pokemonType) {
        this.pokemonTypeDetails = pokemonType;
    }
}