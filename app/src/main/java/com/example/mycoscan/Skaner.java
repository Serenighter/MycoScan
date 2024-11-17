package com.example.mycoscan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class Skaner extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skaner);

        if (savedInstanceState == null) {
            DropdownMenuFragment dropdownFragment = DropdownMenuFragment.newInstance("Skaner");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, dropdownFragment)
                    .commit();
        }
    }
}
