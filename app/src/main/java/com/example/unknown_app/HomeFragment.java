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
    ImageView bca,bba,bcom,bcasem2,bcasem3,bcomsem1;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        greettextview = view.findViewById(R.id.greetingtextview);
        bca = view.findViewById(R.id.bca);
        bba = view.findViewById(R.id.bba);
        bcom = view.findViewById(R.id.bcom);
        bcasem2 = view.findViewById(R.id.bcasem2);
        bcasem3 = view.findViewById(R.id.bcasem3);

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

        bba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), bba_Activity.class);
                startActivity(intent);

            }
        });
        bcasem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), bca_Activity.class);
                startActivity(intent);
            }
        });
        bcasem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), bcasem3.class);
                startActivity(intent);
            }
        });


        return view;
    }
}