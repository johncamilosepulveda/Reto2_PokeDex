package control;

import android.content.Intent;
import android.view.View;

import com.example.reto2_pokedex.Activity.MainActivity;
import com.example.reto2_pokedex.Activity.PokemonListActivity;
import com.example.reto2_pokedex.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.UUID;

import model.Pokemon;
import model.User;

public class MainController implements View.OnClickListener {

    private MainActivity view;
    private Pokemon pokemon;

    private FirebaseFirestore db;

    public MainController(MainActivity view) {
        this.view = view;
        view.getLoginBtn().setOnClickListener(this);

        db = FirebaseFirestore.getInstance();

    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.buttonIngresar:

                String username = view.getUserNameTextPlain().getText().toString();
                User user = new User(UUID.randomUUID().toString(), username);

                CollectionReference userRef = db.collection("users");
                Query query = userRef.whereEqualTo("username", username);
                query.get().addOnCompleteListener(

                        task -> {

                            if(task.isSuccessful()){
                                if(task.getResult().size() > 0){
                                    for(QueryDocumentSnapshot documentSnapshot : task.getResult()){
                                        User dbUser = documentSnapshot.toObject(User.class);
                                        goToPokemonList(dbUser);
                                        break;
                                    }
                                }else{
                                    db.collection("users").document(user.getId()).set(user);
                                    goToPokemonList(user);
                                }
                            }

                        }

                );
                break;
        }

    }

    private void goToPokemonList(User user) {

        Intent i = new Intent(view, PokemonListActivity.class);
        i.putExtra("myUser", user);
        view.startActivity(i);

    }

}
