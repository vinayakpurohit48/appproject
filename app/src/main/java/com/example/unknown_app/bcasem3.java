package com.example.unknown_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class bcasem3 extends AppCompatActivity {

    CardView stat,se,dhp,oops,mad,wd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bcasem3);
        stat = (CardView) findViewById(R.id.stat);
        se = (CardView) findViewById(R.id.se);
        dhp = (CardView) findViewById(R.id.dhp);
        oops = (CardView) findViewById(R.id.oops);
        mad = (CardView) findViewById(R.id.mad);
        wd = (CardView) findViewById(R.id.wd);

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chapter_Activity.class);
                intent.putExtra("sub","stat");
                startActivity(intent);
            }
        });

        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chapter_Activity.class);
                intent.putExtra("sub","se");
                startActivity(intent);
            }
        });

        dhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chapter_Activity.class);
                intent.putExtra("sub","dhp");
                startActivity(intent);
            }
        });

        oops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chapter_Activity.class);
                intent.putExtra("sub","oops");
                startActivity(intent);
            }
        });

        mad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chapter_Activity.class);
                intent.putExtra("sub","mad");
                startActivity(intent);
            }
        });

        wd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Chapter_Activity.class);
                intent.putExtra("sub","wd");
                startActivity(intent);
            }
        });

    }
}