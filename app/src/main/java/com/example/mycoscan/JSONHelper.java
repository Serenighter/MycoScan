package com.example.mycoscan;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONHelper {

    public static List<Mushroom> loadMushroomsFromAssets(Context context) {
        try {
            InputStream inputStream = context.getAssets().open("mushrooms.json");
            InputStreamReader reader = new InputStreamReader(inputStream);

            Gson gson = new Gson();
            MushroomData mushroomData = gson.fromJson(reader, MushroomData.class);

            reader.close();
            inputStream.close();

            return mushroomData.getMushrooms();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class MushroomData {
        private List<Mushroom> mushrooms;

        public List<Mushroom> getMushrooms() {
            return mushrooms;
        }

        public void setMushrooms(List<Mushroom> mushrooms) {
            this.mushrooms = mushrooms;
        }
    }
}