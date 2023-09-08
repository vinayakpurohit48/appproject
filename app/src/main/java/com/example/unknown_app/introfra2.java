package com.example.unknown_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class introfra2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_introfra2, container, false);
        Button backbtn = view.findViewById(R.id.backbtn);
        Button finishbtn = view.findViewById(R.id.finishbtn);
       finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent introtoregister = new Intent(getActivity(), MainActivity.class);
                startActivity(introtoregister);
                getActivity().finish();
            }
        });
       backbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Fragment fragment = new introfrag1();
               FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
               fragmentTransaction.replace(R.id.fragmentcontainer,fragment).commit();
           }
       });

        return view;
    }
}