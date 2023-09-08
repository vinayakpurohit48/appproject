package com.example.unknown_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView rtologin;
    EditText email,password,name, mobileno;
    Button registerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rtologin = (TextView) findViewById(R.id.rtologin);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        registerbtn = (Button) findViewById(R.id.registerbtn);
        name = (EditText) findViewById(R.id.name);
        mobileno = (EditText) findViewById(R.id.mobileno);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edusername = email.getText().toString();
                String edpass = password.getText().toString();
                String edname = name.getText().toString();
                String edmobileno = mobileno.getText().toString();
                if(edusername.equals("") || edpass.equals("") || edmobileno.equals("") || edname.equals(""))
                {
                    raiserror(edusername,email);
                    raiserror(edpass,password);
                    raiserror(edmobileno,mobileno);
                    raiserror(edname,name);
                    Toast.makeText(MainActivity.this, "Please Enter All Detail", Toast.LENGTH_SHORT).show();
                }else {

                    Intent registertologin = new Intent(getApplicationContext(), LoginActivity.class);
                    registertologin.putExtra("usernm", edusername);
                    registertologin.putExtra("pass", edpass);
                    registertologin.putExtra("Name", edname);
                    registertologin.putExtra("mobileno",edmobileno);
                    startActivity(registertologin);
                    finish();
                }
            }
        });
    }
    public void rtologinclicked(View view){
        Intent rtologin = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(rtologin);
        finish();
    }
    public void raiserror(String string, EditText editText){
        if(string.isEmpty()){
            editText.setError("This field can't be Empty");
        }
    }
}