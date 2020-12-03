package control;

import android.view.View;

import com.example.reto2_pokedex.Activity.PokemonAdapter;
import com.example.reto2_pokedex.Activity.PokemonListActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import events.OnGetPokemon;
import model.Pokemon;
import util.Actions;

public class PokemonListController implements View.OnClickListener, OnGetPokemon {

    private PokemonListActivity view;
    private Actions actions;

    private PokemonAdapter pokemonAdapter;

    private FirebaseFirestore db;

    public PokemonListController(PokemonListActivity view) {
        this.view = view;

        view.getCatchBtn().setOnClickListener(this);
        view.getSearchBtn().setOnClickListener(this);

        actions = new Actions();
        actions.setOnGetPokemon(this);

        db = FirebaseFirestore.getInstance();
        pokemonAdapter = new PokemonAdapter();

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onGetPokemonAPI(Pokemon pokemon) {

    }
}
