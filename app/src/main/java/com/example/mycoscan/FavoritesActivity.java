package com.example.mycoscan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {
    private RecyclerView favoritesRecyclerView;
    private MushroomAdapter adapter;
    private List<Mushroom> mushroomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulubione);

        mushroomList = JSONHelper.loadMushroomsFromAssets(this);

        RecyclerView recyclerView = findViewById(R.id.favoritesRecyclerView);
        adapter = new MushroomAdapter(this, mushroomList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        favoritesRecyclerView = findViewById(R.id.favoritesRecyclerView);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Mushroom> favoriteMushrooms = loadFavorites();
        adapter = new MushroomAdapter(this, favoriteMushrooms);
        favoritesRecyclerView.setAdapter(adapter);
    }

    private List<Mushroom> loadFavorites() {
        List<Mushroom> allMushrooms = JSONHelper.loadMushroomsFromAssets(this);
        List<Mushroom> favorites = new ArrayList<>();
        for (Mushroom mushroom : allMushrooms) {
            if (mushroom.isFavorite()) {
                favorites.add(mushroom);
            }
        }
        return favorites;
    }
}