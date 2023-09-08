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
    String oldpassword,changedpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordchange);

        edoldpassword = (EditText) findViewById(R.id.edoldpassword);
        ednewpassword = (EditText) findViewById(R.id.ednewpass);
        edconfirmpassword = (EditText) findViewById(R.id.edcnfpass);
        btnchangepassword = (Button) findViewById(R.id.btnchangepass);
        changepass();
        btnchangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edoldpassword.getText().toString().equals(oldpassword)) {
                    if (ednewpassword.getText().toString().equals(edconfirmpassword.getText().toString())) {
                        if (!ednewpassword.getText().toString().equals(oldpassword)) {
                            changedpassword = ednewpassword.getText().toString();
                            Intent forgottologin = new Intent(getApplicationContext(), LoginActivity.class);
                            forgottologin.putExtra("changedpassword",changedpassword);
                            startActivity(forgottologin);
                        } else {
                            Toast.makeText(getApplicationContext(), "!! Please Enter Different password !!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "!! password does not match !!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "!! Wrong old password !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void changepass(){
        Intent inte = getIntent();
        oldpassword = inte.getStringExtra("oldpass");
    }
}