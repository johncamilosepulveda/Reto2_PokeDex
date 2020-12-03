package com.example.reto2_pokedex.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.reto2_pokedex.R;

import control.PokemonListController;
import model.User;

public class PokemonListActivity extends AppCompatActivity {

    private Button catchBtn, searchBtn;
    private EditText searchText;
    private User myuser;
    private RecyclerView pokemonRecycler;
    private PokemonListController pokemonListController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catchBtn = findViewById(R.id.buttonAtrapar);
        searchBtn = findViewById(R.id.buttonBuscar);
        searchText = findViewById(R.id.editTextNameId);
        pokemonRecycler = findViewById(R.id.pokemonRecycler);

        pokemonRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        pokemonRecycler.setHasFixedSize(true);

        myuser = (User) getIntent().getExtras().getSerializable("myUser");

        pokemonListController = new PokemonListController(this);

    }

    public Button getCatchBtn() {
        return catchBtn;
    }

    public void setCatchBtn(Button catchBtn) {
        this.catchBtn = catchBtn;
    }

    public Button getSearchBtn() {
        return searchBtn;
    }

    public void setSearchBtn(Button searchBtn) {
        this.searchBtn = searchBtn;
    }

    public EditText getSearchText() {
        return searchText;
    }

    public void setSearchText(EditText searchText) {
        this.searchText = searchText;
    }

    public User getMyuser() {
        return myuser;
    }

    public void setMyuser(User myuser) {
        this.myuser = myuser;
    }

    public RecyclerView getPokemonRecycler() {
        return pokemonRecycler;
    }

    public void setPokemonRecycler(RecyclerView pokemonRecycler) {
        this.pokemonRecycler = pokemonRecycler;
    }
}