package com.example.unknown_app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    TextView greettextview;
    ImageView bca,bba,bcom;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        greettextview = view.findViewById(R.id.greetingtextview);
        bca = view.findViewById(R.id.bca);
        bba = view.findViewById(R.id.bba);
        bcom = view.findViewById(R.id.bcom);

        Bundle args = getArguments();
        String name = args.getString("Name");

        greettextview.setText("Hello "+name);

        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bca_Activity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}