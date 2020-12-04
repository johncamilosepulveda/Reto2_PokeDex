package com.example.reto2_pokedex.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reto2_pokedex.R;

import control.PokemonViewController;
import model.Pokemon;
import model.User;

public class PokemonViewActivity extends AppCompatActivity {

    private Button dropBtn;
    private TextView pokeName, pokeType, defensaValue, ataqueValue, velocidadValue, vidaValue;
    private TextView Text1, Text2, Text3, Text4;
    private ImageView pokemonIV;

    private User myuser;
    private Pokemon pokemon;
    private PokemonViewController pokemonViewController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_view);
    }

    public Button getDropBtn() {
        return dropBtn;
    }

    public void setDropBtn(Button dropBtn) {
        this.dropBtn = dropBtn;
    }

    public TextView getPokeName() {
        return pokeName;
    }

    public void setPokeName(TextView pokeName) {
        this.pokeName = pokeName;
    }

    public TextView getPokeType() {
        return pokeType;
    }

    public void setPokeType(TextView pokeType) {
        this.pokeType = pokeType;
    }

    public TextView getDefensaValue() {
        return defensaValue;
    }

    public void setDefensaValue(TextView defensaValue) {
        this.defensaValue = defensaValue;
    }

    public TextView getAtaqueValue() {
        return ataqueValue;
    }

    public void setAtaqueValue(TextView ataqueValue) {
        this.ataqueValue = ataqueValue;
    }

    public TextView getVelocidadValue() {
        return velocidadValue;
    }

    public void setVelocidadValue(TextView velocidadValue) {
        this.velocidadValue = velocidadValue;
    }

    public TextView getVidaValue() {
        return vidaValue;
    }

    public void setVidaValue(TextView vidaValue) {
        this.vidaValue = vidaValue;
    }

    public TextView getText1() {
        return Text1;
    }

    public void setText1(TextView text1) {
        Text1 = text1;
    }

    public TextView getText2() {
        return Text2;
    }

    public void setText2(TextView text2) {
        Text2 = text2;
    }

    public TextView getText3() {
        return Text3;
    }

    public void setText3(TextView text3) {
        Text3 = text3;
    }

    public TextView getText4() {
        return Text4;
    }

    public void setText4(TextView text4) {
        Text4 = text4;
    }

    public ImageView getPokemonIV() {
        return pokemonIV;
    }

    public void setPokemonIV(ImageView pokemonIV) {
        this.pokemonIV = pokemonIV;
    }

    public User getMyuser() {
        return myuser;
    }

    public void setMyuser(User myuser) {
        this.myuser = myuser;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public PokemonViewController getPokemonViewController() {
        return pokemonViewController;
    }

    public void setPokemonViewController(PokemonViewController pokemonViewController) {
        this.pokemonViewController = pokemonViewController;
    }
}