package com.example.mycoscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Pomoc extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pomoc);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public void kot(View view) {
        Intent intent = new Intent(this, Pomoc.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_skaner) {
            // Przejście do ekranu Skaner
            Intent intent = new Intent(this, Skaner.class);
            startActivity(intent);

        } else if (id == R.id.nav_atlas_grzybów) {
            // Przejście do ekranu Atlas Grzybów
            Intent intent = new Intent(this, AtlasGrzybow.class);
            startActivity(intent);

        } else if (id == R.id.nav_ulubione) {
            // Przejście do ekranu Ulubione
            Intent intent = new Intent(this, Ulubione.class);
            startActivity(intent);

        } else if (id == R.id.nav_ocen) {
            // Przejście do ekranu Oceń nas
            Intent intent = new Intent(this, OcenNas.class);
            startActivity(intent);

        } else if (id == R.id.nav_onas) {
            // Przejście do ekranu Twórcy
            Intent intent = new Intent(this, Onas.class);
            startActivity(intent);
        }

        // Zamknij szufladę po kliknięciu w element menu
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

