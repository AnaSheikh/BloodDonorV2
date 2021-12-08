package com.example.blooddonorv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnLogin, btnSignUp;
    CheckBox alreadyUser;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.login);
        DB = new DBHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginActivity.this,"Please fill Username and Password both",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean checkUserAndPass = DB.checkUsernameAndPassword(user,pass);
                    if(checkUserAndPass==true)
                    {
                        Toast.makeText(LoginActivity.this,"Sign in Successfull",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),ViewDonors.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}