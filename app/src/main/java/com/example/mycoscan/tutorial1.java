package com.example.mycoscan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class tutorial1 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_ekran_1);

        //Przejście do tutorial2
        Button nextButton = findViewById(R.id.next_button_1);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial1.this, tutorial2.class);
                startActivity(intent);
            }
        });

        //Przejście do głównego ekranu
        Button secoundButton = findViewById(R.id.skip_button_1);
        secoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutorial1.this, Skaner.class);
                startActivity(intent);
            }
        });

    }
}
