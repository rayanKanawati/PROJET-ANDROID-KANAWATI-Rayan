package com.example.tp3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApi  {

    @GET("/api/v2/pokemon?limit=807")
    Call<RestPokemonResponse> getPokemonResponse();


}

