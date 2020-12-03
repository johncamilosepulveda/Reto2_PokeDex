package com.example.reto2_pokedex.Activity;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reto2_pokedex.R;

import org.w3c.dom.Text;

public class PokemonView extends RecyclerView.ViewHolder {

    private ConstraintLayout root;
    private ImageView pokemonImage;
    private TextView pokemonNameText;

    public PokemonView(ConstraintLayout root) {

        super(root);

        this.root = root;
        pokemonImage = root.findViewById(R.id.pokemonImage);
        pokemonNameText = root.findViewById(R.id.pokemonNameText);

    }

    public ConstraintLayout getRoot() {
        return root;
    }

    public void setRoot(ConstraintLayout root) {
        this.root = root;
    }

    public ImageView getPokemonImage() {
        return pokemonImage;
    }

    public void setPokemonImage(ImageView pokemonImage) {
        this.pokemonImage = pokemonImage;
    }

    public TextView getPokemonNameText() {
        return pokemonNameText;
    }

    public void setPokemonNameText(TextView pokemonNameText) {
        this.pokemonNameText = pokemonNameText;
    }
}
