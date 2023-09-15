package com.example.unknown_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    String name, email, mobileno;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bnview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent logindata = getIntent();

        name = logindata.getStringExtra("Name");
        email = logindata.getStringExtra("email");
        mobileno = logindata.getStringExtra("mobileNo");

            HomeFragment homeFragment = new HomeFragment();
            Bundle args = new Bundle();
            args.putString("Name", name);
            homeFragment.setArguments(args);

            fragmentLoader(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home) {
                    HomeFragment homeFragment = new HomeFragment();
                    Bundle args = new Bundle();
                    args.putString("Name", name);
                    homeFragment.setArguments(args);

                    fragmentLoader(homeFragment);
                } else if (id == R.id.quiz) {
                    fragmentLoader(new QuizFragment());
                } else {
                    ProfileFragment profileFragment = new ProfileFragment();
                    Bundle args = new Bundle();
                    args.putString("Name", name);
                    args.putString("Email", email);
                    args.putString("MobileNo", mobileno);
                    profileFragment.setArguments(args);

                    fragmentLoader(profileFragment);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.itemregister) {
            Intent itemToRegister = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(itemToRegister);
        } else if (id == R.id.itemsetting) {
            Toast.makeText(this, "Setting is not available for this page", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.itemexit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void fragmentLoader(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containeroffragment, fragment).commit();
    }
}
