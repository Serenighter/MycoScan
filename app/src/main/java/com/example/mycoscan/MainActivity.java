package com.example.mycoscan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); //extends the app even to the navigation bar and home buttons!

        SharedPreferences preferences = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean isFirstLaunch = preferences.getBoolean("isFirstLaunch", true);

        if (isFirstLaunch) {  //if statement to check whether the app is opened for the first time, if so launch tutorial
            Intent intent = new Intent(this, Tutorial.class);
            startActivity(intent);
            finish();

            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstLaunch", false);
            editor.apply();
        } else {
            setContentView(R.layout.activity_main);
        }

        if (savedInstanceState == null) {
            DropdownMenuFragment dropdownFragment = DropdownMenuFragment.newInstance("Menu");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, dropdownFragment)
                    .commit();
        }
        Button button1 = (Button) findViewById(R.id.pomocButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Pomoc.class);
                view.getContext().startActivity(intent);}
        });
    }
}
