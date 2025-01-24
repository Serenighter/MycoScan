package com.example.mycoscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class tutorial5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_ekran_5);

        //Przejście do skanera
        Button nextButton = findViewById(R.id.next_button_5);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial5.this, Skaner.class);
                startActivity(intent);
            }
        });

        //Przejście do tutorial4
        Button secoundButton = findViewById(R.id.back_button_5);
        secoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial5.this, tutorial4.class);
                startActivity(intent);
            }
        });


    }
}