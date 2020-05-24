package com.example.tp3.presentation.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tp3.R;
import com.example.tp3.Singletons;
import com.example.tp3.presentation.controller.MainController;
import com.example.tp3.presentation.model.Pokemon;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private LayoutManager layoutManager;


    private MainController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new MainController(
              this,
                Singletons.getGson(),
                Singletons.getSharedPreferencesInstance(getApplicationContext())
        );
        controller.onStart();

    }



    public void showList(List<Pokemon> PokemonList){
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);




        // define an adapter
        mAdapter = new ListAdapter(PokemonList, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pokemon item) {
                controller.onItemCLick(item);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }




    public void showError() {
        Toast.makeText(getApplicationContext(), "API Error", Toast.LENGTH_SHORT).show();
    }

    public void navigateToDetails(Pokemon pokemon) {
        Intent myIntent = new Intent(MainActivity.this, DetailsActivity.class);
        myIntent.putExtra("pokemonKey", Singletons.getGson().toJson(pokemon)); //Optional parameters
        MainActivity.this.startActivity(myIntent);

    }
}
