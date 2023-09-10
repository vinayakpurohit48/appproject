package com.example.unknown_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView newacc, forgotpassbtn;
    EditText eusername, epassword;
    Button loginbtn;
    String username, password, mobileno, name, changedpassword;
    int attemp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        newacc = (TextView) findViewById(R.id.newacc);
        eusername = (EditText) findViewById(R.id.eusername);
        epassword = (EditText) findViewById(R.id.epassword);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        forgotpassbtn = (TextView) findViewById(R.id.btnforgotpassword);

        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
        Intent dataregister = getIntent();
        username = dataregister.getStringExtra("usernm");
        password = dataregister.getStringExtra("pass");
        name = dataregister.getStringExtra("Name");
        mobileno = dataregister.getStringExtra("mobileno");
        changedpassword = dataregister.getStringExtra("changedpassword");



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernm = eusername.getText().toString();
                String edpass = epassword.getText().toString();

                if (attemp < 3) {
                    if (usernm.equals("") || edpass.equals("")) {
                        raiseerror(usernm, eusername);
                        raiseerror(edpass, epassword);
                    } else {
                        if (usernm.equals(username) && edpass.equals(password) || edpass.equals(changedpassword)) {
                            Toast.makeText(LoginActivity.this, "Logined Success", Toast.LENGTH_SHORT).show();
                            Intent logintohome = new Intent(getApplicationContext(), HomeActivity.class);
                            logintohome.putExtra("Name", name);
                            logintohome.putExtra("mobileno", mobileno);
                            logintohome.putExtra("email", username);
                            startActivity(logintohome);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "!! Something Went wrong !!" + "You have " + (3 - attemp) + "Attempt Left", Toast.LENGTH_SHORT).show();
                            attemp = attemp + 1;
                        }
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "Account Suspended", Toast.LENGTH_SHORT).show();
                    Intent logintoregister = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(logintoregister);
                }
            }
        });
        forgotpassbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logintoforgotpass = new Intent(getApplicationContext(), passwordchangeActivity.class);
                logintoforgotpass.putExtra("oldpass", password);
                startActivity(logintoforgotpass);
            }
        });
    }
    public void raiseerror(String string, EditText editText){
        if(string.isEmpty())
            editText.setError("This Field can't be Empty");
    }
}