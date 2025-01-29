package com.example.mycoscan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MushroomItemFragment extends Fragment {

    private static final String ARG_NAME = "name";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_ICON_RESOURCE = "iconResource";
    private static final String ARG_IS_FAVORITE = "isFavorite";

    private String name;
    private String description;
    private String iconResource;
    private boolean isFavorite;

    public static MushroomItemFragment newInstance(String name, String description, String iconResource, boolean isFavorite) {
        MushroomItemFragment fragment = new MushroomItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_ICON_RESOURCE, iconResource);
        args.putBoolean(ARG_IS_FAVORITE, isFavorite);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            description = getArguments().getString(ARG_DESCRIPTION);
            iconResource = getArguments().getString(ARG_ICON_RESOURCE);
            isFavorite = getArguments().getBoolean(ARG_IS_FAVORITE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.item_mushroom, container, false);

        TextView mushroomName = view.findViewById(R.id.mushroomName);
        TextView mushroomDescription = view.findViewById(R.id.mushroomDescription);
        ImageView mushroomIcon = view.findViewById(R.id.mushroomIcon);
        ImageView favoriteIcon = view.findViewById(R.id.favoriteIcon);

        mushroomName.setText(name);
        mushroomDescription.setText(description);

        int iconResId = getResources().getIdentifier(
                iconResource,
                "drawable",
                requireContext().getPackageName()
        );
        mushroomIcon.setImageResource(iconResId);

        if (isFavorite) {
            favoriteIcon.setImageResource(R.drawable.fav_icon);
        } else {
            favoriteIcon.setImageResource(R.drawable.quest_icon);
        }

        return view;
    }
}
