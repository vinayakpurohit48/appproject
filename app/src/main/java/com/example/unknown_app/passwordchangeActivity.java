package com.example.unknown_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class passwordchangeActivity extends AppCompatActivity {

    EditText edoldpassword,ednewpassword,edconfirmpassword;
    Button btnchangepassword;
    String oldpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordchange);

        edoldpassword = (EditText) findViewById(R.id.edoldpassword);
        ednewpassword = (EditText) findViewById(R.id.ednewpass);
        edconfirmpassword = (EditText) findViewById(R.id.edcnfpass);
        btnchangepassword = (Button) findViewById(R.id.btnchangepass);
    }
    public void changepass(View view){
        Intent inte = getIntent();
        oldpassword = inte.getStringExtra("password");
        Toast.makeText(passwordchangeActivity.this, "hello", Toast.LENGTH_SHORT).show();
    }
}