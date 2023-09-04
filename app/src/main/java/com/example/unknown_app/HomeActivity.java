package com.example.unknown_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    String name,email,mobileno;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent logindata = getIntent();

        name = logindata.getStringExtra("Name");
        mobileno = logindata.getStringExtra("email");
        email = logindata.getStringExtra("mobileno");

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();

            if(id==R.id.home){

                HomeFragment homeFragment = new HomeFragment();
                Bundle args = new Bundle();
                args.putString("Name",name);
                homeFragment.setArguments(args);

                fragmentloder(homeFragment,false);
            } else if (id==R.id.quiz) {
                fragmentloder(new QuizFragment(),false);

            } else {

                ProfileFragment profileFragment = new ProfileFragment();

                Bundle args = new Bundle();
                args.putString("Name", name);
                args.putString("Email", email);
                args.putString("MobileNo", mobileno);
                profileFragment.setArguments(args);

                fragmentloder(profileFragment, false);
            }

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void fragmentloder(Fragment fragment, boolean flag){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (flag){
            fragmentTransaction.add(R.id.containeroffragment,fragment);
            fragmentTransaction.commit();
        }else{
            fragmentTransaction.replace(R.id.containeroffragment,fragment);
            fragmentTransaction.commit();
        }
    }
}
