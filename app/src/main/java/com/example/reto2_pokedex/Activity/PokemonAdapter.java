package com.example.reto2_pokedex.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.reto2_pokedex.R;

import java.util.ArrayList;

import model.Pokemon;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonView> implements View.OnClickListener {

    private ArrayList<Pokemon> pokemon;
    private View.OnClickListener listener;

    public PokemonAdapter() { pokemon = new ArrayList<>(); }

    public void addPokemon(Pokemon myPokemon) {

        pokemon.add(myPokemon);
        this.notifyDataSetChanged();

    }

    public View.OnClickListener getListener() { return listener; }

    public void setListener(View.OnClickListener listener) { this.listener = listener; }

    public PokemonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.recycler_view_pokemon, null);
        row.setOnClickListener(this);
        ConstraintLayout rowroot = (ConstraintLayout) row;
        PokemonView pokemonView = new PokemonView(rowroot);

        return pokemonView;

    }

    public void onBindViewHolder(@NonNull PokemonView holder, int position){
        holder.getPokemonNameText().setText(pokemon.get(position).getPokemonName());
        Glide.with(holder.getRoot()).load(pokemon.get(position).getSprites().getFront_default()).centerCrop().into(holder.getPokemonImage());
    }

    public int getItemCount(){
        return pokemon.size();
    }

    public void onClick(View v){
        if(listener != null){
            listener.onClick(v);
        }
    }

}
