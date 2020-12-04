package control;

import android.content.Intent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;

import com.example.reto2_pokedex.Activity.PokemonAdapter;
import com.example.reto2_pokedex.Activity.PokemonListActivity;
import com.example.reto2_pokedex.Activity.PokemonView;
import com.example.reto2_pokedex.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

import java.sql.Array;
import java.util.ArrayList;
import java.util.UUID;

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

        loadPokemonFireBase();

    }

    public void addEventPokemonAdapter(){
        pokemonAdapter.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view, PokemonViewActivity.class);
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonAtrapar:
                if(view.getSearchText().getText() == null || view.getCatchText().getText().toString().equals("")){
                    Toast.makeText(view, "No hay nombre de pokemon para atrapar", Toast.LENGTH_LONG).show();
                }else{
                    actions.getPokemon(view.getCatchText().getText().toString());
                }
                break;

            case R.id.buttonBuscar:
                if(view.getSearchText().getText() == null || view.getSearchText().getText().toString().equals("")) {
                    Toast.makeText(view, "no hay nombre o Id de pokemon para buscar", Toast.LENGTH_LONG).show();
                }else{
                    searchPokemonFireBase(view.getSearchText().toString());
                }
        }

    }

    @Override
    public void onGetPokemonAPI(Pokemon pokemon) {
        pokemon.setPokemonId(UUID.randomUUID().toString());
        pokemon.setPokemonName(pokemon.getForms().get(0).getName());

        db.collection("users").document(view.getMyuser().getId())
                .collection("pokemon").document(pokemon.getPokemonId()).set(pokemon);

        view.runOnUiThread(

                ()->{
                    pokemonAdapter.addPokemon(pokemon);
                }
        );

    }

    public void loadPokemonFireBase(){
        ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
        String userNameId = view.getMyuser().getId();

        CollectionReference pokemonRef = db.collection("users").document(userNameId).collection("pokemon");

        pokemonRef.get().addOnCompleteListener(

                task -> {
                    for(DocumentSnapshot documentSnapshot : task.getResult()){
                        Pokemon dbPokemon = documentSnapshot.toObject(Pokemon.class);
                        pokemonArrayList.add(dbPokemon);
                    }
                }

        );

        view.runOnUiThread(

                () -> {
                    pokemonAdapter.setPokemon(pokemonArrayList);
                    view.getPokemonRecycler().setAdapter(pokemonAdapter);
                    addEventPokemonAdapter();
                }
        );

    }

}
