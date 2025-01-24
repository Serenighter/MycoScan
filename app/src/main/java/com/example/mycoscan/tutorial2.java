package com.example.mycoscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class tutorial2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_ekran_2);

        //Przejście do tutorial3
        Button nextButton = findViewById(R.id.next_button_2);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial2.this, tutorial3.class);
                startActivity(intent);
            }
        });

        //Przejście do Skaner
        Button secoundButton = findViewById(R.id.skip_button_2);
        secoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial2.this, Skaner.class);
                startActivity(intent);
            }
        });

        //Przejście do tutorial1
        Button thirdButton = findViewById(R.id.back_button_2);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial2.this, tutorial1.class);
                startActivity(intent);
            }
        });
    }
}