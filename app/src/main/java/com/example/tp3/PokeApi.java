package com.example.tp3;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApi  {

    @GET("/api/v2/pokemon?limit=1500")
    Call<RestPokemonResponse> getPokemonResponse();


}
