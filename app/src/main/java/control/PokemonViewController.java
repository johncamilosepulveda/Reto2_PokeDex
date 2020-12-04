package control;

import android.view.View;

import com.example.reto2_pokedex.Activity.PokemonViewActivity;
import com.example.reto2_pokedex.R;
import com.google.firebase.firestore.FirebaseFirestore;

public class PokemonViewController implements View.OnClickListener{

    private PokemonViewActivity view;

    private FirebaseFirestore db;

    public PokemonViewController(PokemonViewActivity view){
        this.view = view;
        view.getDropBtn().setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bu
        }

    }
}
