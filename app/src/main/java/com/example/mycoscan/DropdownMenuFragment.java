package com.example.mycoscan;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;

public class DropdownMenuFragment extends Fragment {

    private MaterialAutoCompleteTextView menuOption;

    public static DropdownMenuFragment newInstance(String selectedItem) {
        DropdownMenuFragment fragment = new DropdownMenuFragment();
        Bundle args = new Bundle();
        //args.putInt("HINT_ID", hintId); //hint not needed
        args.putString("Selected_Item", selectedItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dropdown, container, false);

        menuOption = rootView.findViewById(R.id.menuOption);

        menuOption.setDropDownBackgroundDrawable( //method for coloring the menu that drops down after pressing the button!
                new ColorDrawable(ContextCompat.getColor(requireContext(), R.color.light_brown))
        );

        if (getArguments() != null) {
            //int hintId = getArguments().getInt("HINT_ID", R.string.menu_hint); //-hint not needed
            String selectedItem = getArguments().getString("Selected_Item", "Menu");
            //menuOption.setHint(getString(hintId)); //-hint not needed
            menuOption.setText(selectedItem);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.dropdown_item_layout, getResources().getStringArray(R.array.menu_options));
        menuOption.setAdapter(adapter);

        menuOption.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedOption = (String) parent.getItemAtPosition(position);

                handleOptionSelection(selectedOption);
            }
        });
        return rootView;
    }

    private void handleOptionSelection(String selectedOption) {

        switch (selectedOption) {
            case "Menu":
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                break;
            case "Skaner":
                Intent activityIntent = new Intent(getActivity(), Skaner.class);
                startActivity(activityIntent);
                break;
            case "Ulubione":
                Intent activity2Intent = new Intent(getActivity(), Ulubione.class);
                startActivity(activity2Intent);
                break;
            case "Pomoc":
                Intent activity3Intent = new Intent(getActivity(), Pomoc.class);
                startActivity(activity3Intent);
                break;
            case "Atlas Grzybów":
                Intent activity4Intent = new Intent(getActivity(), AtlasGrzybow.class);
                startActivity(activity4Intent);
                break;
            case "Start":
                Intent activity5Intent = new Intent(getActivity(), Start.class);
                startActivity(activity5Intent);
                break;
            default:
                Toast.makeText(getContext(), "Unknown option", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
