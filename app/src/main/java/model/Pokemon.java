package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pokemon implements Serializable {

    private ArrayList<StatContainer> stats;
    private ArrayList<TypeContainer> types;
    private ArrayList<Form> forms;
    private Sprite sprites;
    private String pokemonName;
    private String pokemonId;

    public Pokemon(ArrayList<StatContainer> stats, ArrayList<TypeContainer> types, ArrayList<Form> forms, Sprite sprites, String pokemonName, String pokemonId) {
        this.stats = stats;
        this.types = types;
        this.forms = forms;
        this.sprites = sprites;
        this.pokemonName = pokemonName;
        this.pokemonId = pokemonId;
    }

    public Pokemon() {
    }

    public ArrayList<StatContainer> getStats() {
        return stats;
    }

    public void setStats(ArrayList<StatContainer> stats) {
        this.stats = stats;
    }

    public ArrayList<TypeContainer> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<TypeContainer> types) {
        this.types = types;
    }

    public ArrayList<Form> getForms() {
        return forms;
    }

    public void setForms(ArrayList<Form> forms) {
        this.forms = forms;
    }

    public Sprite getSprites() {
        return sprites;
    }

    public void setSprites(Sprite sprites) {
        this.sprites = sprites;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(String pokemonId) {
        this.pokemonId = pokemonId;
    }
}
