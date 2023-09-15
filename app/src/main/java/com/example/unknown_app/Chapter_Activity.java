package com.example.unknown_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Chapter_Activity extends Activity {

    private ListView chapterListView;
    private String[] chapters = {"Chapter 1", "Chapter 2", "Chapter 3", "Chapter 4", "Chapter 5"};
    String sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);

        chapterListView = findViewById(R.id.chapterlist);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chapters);
        chapterListView.setAdapter(adapter);

        Intent intent = getIntent();
        sub = intent.getStringExtra("sub");

        chapterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if(sub.equals("stat")){
                    Toast.makeText(Chapter_Activity.this, "Stat ch - " + i, Toast.LENGTH_SHORT).show();
                } else if (sub.equals("se")) {
                    Toast.makeText(Chapter_Activity.this, "se ch - " + i, Toast.LENGTH_SHORT).show();
                } else if (sub.equals("dhp")) {
                    Toast.makeText(Chapter_Activity.this, "dhp ch - " + i, Toast.LENGTH_SHORT).show();
                } else if (sub.equals("oops")) {
                    Toast.makeText(Chapter_Activity.this, "oops ch - " + i, Toast.LENGTH_SHORT).show();
                } else if (sub.equals("mad")) {
                    Toast.makeText(Chapter_Activity.this, "mad ch - " + i, Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(Chapter_Activity.this, "wd ch - " + i, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}