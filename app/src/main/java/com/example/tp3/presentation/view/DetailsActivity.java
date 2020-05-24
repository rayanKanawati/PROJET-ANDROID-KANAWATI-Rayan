package com.example.tp3.presentation.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.example.tp3.R;
import com.example.tp3.Singletons;
import com.example.tp3.presentation.controller.MainController;
import com.example.tp3.presentation.model.Pokemon;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetail = findViewById(R.id.detail_txt);
        Intent intent = getIntent();
        String pokemonJson = intent.getStringExtra("pokemonKey"); //if it's a string you stored
        Pokemon pokemon = Singletons.getGson().fromJson(pokemonJson, Pokemon.class);
        showDetail(pokemon);

    }

    private void showDetail(Pokemon pokemon) {
        txtDetail.setText(pokemon.getName());
    }

}
