package com.example.mycoscan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MushroomAdapter extends RecyclerView.Adapter<MushroomAdapter.MushroomViewHolder> {

    private Context context;
    private List<Mushroom> mushroomList;

    public MushroomAdapter(Context context, List<Mushroom> mushroomList) {
        this.context = context;
        this.mushroomList = mushroomList;
    }

    @NonNull
    @Override
    public MushroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mushroom, parent, false);
        return new MushroomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MushroomViewHolder holder, int position) {
        Mushroom mushroom = mushroomList.get(position);
        holder.mushroomName.setText(mushroom.getName());
        holder.mushroomDescription.setText(mushroom.getDescription());

        int iconResId = context.getResources().getIdentifier(
                mushroom.getIconResource(), "drawable", context.getPackageName());
        holder.mushroomIcon.setImageResource(iconResId);

        if (mushroom.isFavorite()) {
            holder.favoriteIcon.setImageResource(R.drawable.fav_icon);
        } else {
            holder.favoriteIcon.setImageResource(R.drawable.quest_icon);
        }

        holder.favoriteIcon.setOnClickListener(v -> {
            //    mushroom.setFavorite(!mushroom.isFavorite());
            //    notifyItemChanged(position);
//        });
//        if (mushroom.isFavorite()) {
//            Toast.makeText(context, mushroom.getName() + " dodano do ulubionych", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, mushroom.getName() + " usunięto z ulubionych", Toast.LENGTH_SHORT).show();
//        }

            int currentPosition = holder.getAdapterPosition();
            if (currentPosition == RecyclerView.NO_POSITION) return;

            Mushroom currentMushroom = mushroomList.get(currentPosition);
            currentMushroom.setFavorite(!currentMushroom.isFavorite());

            String message = currentMushroom.isFavorite() ?
                    "dodano do ulubionych" : "usunięto z ulubionych";
            Toast.makeText(context, currentMushroom.getName() + " " + message, Toast.LENGTH_SHORT).show();

            saveToJSON(context, mushroomList);
            notifyItemChanged(currentPosition);
        });
    }

    @Override
    public int getItemCount() {
        return mushroomList.size();
    }

    public static class MushroomViewHolder extends RecyclerView.ViewHolder {
        TextView mushroomName;
        TextView mushroomDescription;
        ImageView mushroomIcon;
        ImageView favoriteIcon;

        public MushroomViewHolder(@NonNull View itemView) {
            super(itemView);
            mushroomName = itemView.findViewById(R.id.mushroomName);
            mushroomDescription = itemView.findViewById(R.id.mushroomDescription);
            mushroomIcon = itemView.findViewById(R.id.mushroomIcon);
            favoriteIcon = itemView.findViewById(R.id.favoriteIcon);
        }
    }

    private void saveToJSON(Context context, List<Mushroom> mushroomList) {
        Gson gson = new Gson();
        JSONHelper.MushroomData mushroomData = new JSONHelper.MushroomData();
        mushroomData.setMushrooms(mushroomList);

        String jsonString = gson.toJson(mushroomData);

        try {
            FileOutputStream fos = context.openFileOutput("mushrooms.json", Context.MODE_PRIVATE);
            fos.write(jsonString.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
