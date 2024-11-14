package com.example.mycoscan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class Ulubione extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulubione);

        if (savedInstanceState == null) {
            DropdownMenuFragment dropdownFragment = DropdownMenuFragment.newInstance("Ulubione");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, dropdownFragment)
                    .commit();
        }
    }
}