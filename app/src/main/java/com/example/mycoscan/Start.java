package com.example.mycoscan;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Start extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);

        if (savedInstanceState == null) {
            DropdownMenuFragment dropdownFragment = DropdownMenuFragment.newInstance("Start");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, dropdownFragment)
                    .commit();
        }
    }
}

