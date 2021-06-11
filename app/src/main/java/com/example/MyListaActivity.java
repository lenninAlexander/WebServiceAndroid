package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.adapters.PokemonAdapter;
import com.example.entities.Pokemon;
import com.example.services.PokemonService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyListaActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);
            Call<List<Pokemon>> pokecall= service.getAll();

            pokecall.enqueue(new Callback<List<Pokemon>>() {
                @Override
                public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                            List<Pokemon> pokemones = response.body();
                            RecyclerView rv= findViewById(R.id.rvPalabras);
                            rv.setLayoutManager(new LinearLayoutManager(MyListaActivity.this));
                            PokemonAdapter adapter = new PokemonAdapter(pokemones);
                            rv.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Pokemon>> call, Throwable t) {

                }
            });

    }
}