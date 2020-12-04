package control;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.reto2_pokedex.Activity.PokemonViewActivity;
import com.example.reto2_pokedex.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import model.Pokemon;
import model.User;

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
            case R.id.dropBtn:
                dropPokemon();

                break;
        }

    }

    public void dropPokemon(){

        User user = view.getMyuser();
        Pokemon pokemon = view.getPokemon();

        db.collection("users").document(user.getId()).collection("pokemon").document(pokemon.getPokemonId())
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(">>>>>", "DocumentSnapshot successfully deleted!");
                        kill_activity();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(">>>>>>", "Error deleting document", e);
            }
        });

    }

    void kill_activity() { view.finish(); }

}
