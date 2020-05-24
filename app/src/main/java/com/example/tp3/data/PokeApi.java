package com.example.tp3.data;

import com.example.tp3.presentation.model.RestPokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokeApi  {

    @GET("/api/v2/pokemon?limit=807")
    Call<RestPokemonResponse> getPokemonResponse();


}

