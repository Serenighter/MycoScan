package com.example.mycoscan;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); //extends the app even to the navigation bar and home buttons!
        setContentView(R.layout.activity_main); //link .java with .xml

        if (savedInstanceState == null) {
            DropdownMenuFragment dropdownFragment = DropdownMenuFragment.newInstance("Menu");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, dropdownFragment)
                    .commit();
        }
    }
}
