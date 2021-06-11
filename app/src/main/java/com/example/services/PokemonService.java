package com.example.services;

import com.example.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {

       @GET ("pokemons/N00149730")
        Call<List<Pokemon>> getAll();

    @POST("pokemons/N00149730/crear")
    Call<Void> testPost(@Body Pokemon pokemon) ;

}
