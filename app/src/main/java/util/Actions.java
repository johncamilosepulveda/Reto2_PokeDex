package util;

import com.google.gson.Gson;

import co.domi.apunters8.util.HTTPSWebUtilDomi;
import events.OnGetPokemon;
import model.Pokemon;

public class Actions {

    private HTTPSWebUtilDomi https;
    private Gson gson;
    private OnGetPokemon onGetPokemon;

    public void setOnGetPokemon(OnGetPokemon onGetPokemon) { this.onGetPokemon = onGetPokemon; }

    public Actions(){
        https = new HTTPSWebUtilDomi();
        gson = new Gson();
    }

    public void getPokemon(String pokemonName){
        new Thread(

                ()->{
                    String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
                    String response = https.GETrequest(url);
                    Gson gson = new Gson();
                    Pokemon pokemon = gson.fromJson(response, Pokemon.class);
                    if(onGetPokemon!=null) onGetPokemon.onGetPokemonAPI(pokemon);

                }
        ).start();
    }
}
