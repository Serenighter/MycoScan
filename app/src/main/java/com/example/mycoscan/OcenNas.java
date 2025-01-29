package com.example.mycoscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class OcenNas extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    private RatingBar ratingBar;
    private EditText feedbackEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocen_nas);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        // Initialize rating system views
        ratingBar = findViewById(R.id.rating_bar);
        feedbackEditText = findViewById(R.id.et_feedback);
        submitButton = findViewById(R.id.btn_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                String feedback = feedbackEditText.getText().toString().trim();

                if (rating == 0) {
                    Toast.makeText(OcenNas.this, "Podaj ocenę", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(OcenNas.this, "Dziękujemy za opinię!\nOcena: " + rating + "\nFeedback: " + feedback, Toast.LENGTH_LONG).show();

                ratingBar.setRating(0);
                feedbackEditText.setText("");
            }
        });
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

