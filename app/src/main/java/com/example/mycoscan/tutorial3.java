package com.example.mycoscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class tutorial3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_ekran_3);

        //Przejście do tutorial4
        Button nextButton = findViewById(R.id.next_button_3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial3.this, tutorial4.class);
                startActivity(intent);
            }
        });

        //Przejście do Skaner
        Button secoundButton = findViewById(R.id.skip_button_3);
        secoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial3.this, Skaner.class);
                startActivity(intent);
            }
        });

        //Przejście do tutorial2
        Button thirdButton = findViewById(R.id.back_button_3);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial3.this, tutorial2.class);
                startActivity(intent);
            }
        });
    }
}