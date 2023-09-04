package com.example.unknown_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileFragment extends Fragment {

    TextView showname, showemail, showmobileno;
    String name,email,mobileno;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        showname = view.findViewById(R.id.showname);
        showemail = view.findViewById(R.id.showemail);
        showmobileno = view.findViewById(R.id.showmobileno);

        Bundle args = getArguments();
        if (args != null) {
            name = args.getString("Name");
            email = args.getString("Email");
            mobileno = args.getString("MobileNo");

            // Display data in TextViews
            showname.setText(name);
            showemail.setText(email);
            showmobileno.setText(mobileno);
        }

        return view;
    }

}