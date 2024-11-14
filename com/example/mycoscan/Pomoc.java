package com.example.mycoscan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class Pomoc extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomoc);

        if (savedInstanceState == null) {
            DropdownMenuFragment dropdownFragment = new DropdownMenuFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, dropdownFragment).commit();
        }
    }
}