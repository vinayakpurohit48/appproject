package com.example.unknown_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class bca_Activity extends AppCompatActivity {
    ImageView bcasem3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bca);
        bcasem3 = (ImageView) findViewById(R.id.bcasem3);

        bcasem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent semtosub = new Intent(getApplicationContext(),com.example.unknown_app.bcasem3.class);
                startActivity(semtosub);
            }
        });
    }
}