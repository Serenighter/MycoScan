package com.example.mycoscan;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class test extends AppCompatActivity {

    MushroomDatabaseHelper dbHelper;
    TextView tvMushroomData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        // Inicjalizacja obiektów
        dbHelper = new MushroomDatabaseHelper(this);
        tvMushroomData = findViewById(R.id.tvMushroomData);

        // Wyczyść całą tabelę przed załadowaniem nowych danych
        dbHelper.clearAllMushrooms();  // Usuwa wszystkie rekordy

        // Import JSON danych do bazy danych
        loadMushroomsFromJson();

        // Wyświetl dane z bazy danych
        displayMushrooms();
    }

    private void loadMushroomsFromJson() {
        try {
            // Otwórz plik JSON z folderu assets
            InputStream is = getAssets().open("mushrooms.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            // Iteruj przez dane i wstawiaj je do bazy
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String title = obj.getString("title");
                String description = obj.getString("description");
                int edibility = obj.getInt("edibility");
                byte[] image = null; // Możesz dodać obsługę obrazów, jeśli są w JSON

                dbHelper.insertMushroom(title, description, edibility, image);
            }

        } catch (Exception e) {
            Log.e("JSON_ERROR", "Error loading JSON", e);
        }
    }

    private void displayMushrooms() {
        Cursor cursor = dbHelper.getAllMushrooms(); // Funkcja zwracająca dane z bazy
        StringBuilder builder = new StringBuilder();

        // Iteracja przez wyniki kursora
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                String description = cursor.getString(cursor.getColumnIndexOrThrow("description"));
                int edibility = cursor.getInt(cursor.getColumnIndexOrThrow("edibility"));

                // Dodaj dane do StringBuildera
                builder.append("Tytuł: ").append(title).append("\n");
                builder.append("Opis: ").append(description).append("\n");
                builder.append("Poziom jadalności: ").append(edibility).append("\n");
                builder.append("------\n");
            } while (cursor.moveToNext());

            cursor.close();
        }

        // Ustaw dane w TextView
        tvMushroomData.setText(builder.toString());
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Usuwanie wszystkich danych z tabeli przy zamykaniu aktywności
        dbHelper.clearAllMushrooms();
    }
}
