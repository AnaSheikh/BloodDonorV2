package com.example.blooddonorv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText username,password,contact,status,country,blood;
    Button btnRegister;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.Username);
        password = (EditText) findViewById(R.id.Password);
        contact = (EditText) findViewById(R.id.Contact);
        status = (EditText) findViewById(R.id.Status);
        country = (EditText) findViewById(R.id.Country);
        blood = (EditText) findViewById(R.id.Bloodgroup);

        btnRegister = (Button) findViewById(R.id.Register);
        DB = new DBHelper(this);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String con = contact.getText().toString();
                String stat = status.getText().toString();
                String coun = country.getText().toString();
                String bl = blood.getText().toString();

                if(user.equals("")||pass.equals("")||con.equals("")||stat.equals("")||coun.equals("")||bl.equals(""))
                {
                    Toast.makeText(SignupActivity.this,"All fields should have Data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    boolean checkUser  = DB.checkUsername(user);
                    if(checkUser == true)
                    {
                        Toast.makeText(SignupActivity.this,"User already Exists.Please Login to proceed",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                    }
                    boolean insert= DB.insertData(user,pass,con,stat,coun,bl);
                    if(insert == true)
                    {
                        Toast.makeText(SignupActivity.this,"User Register Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                    }
                    else
                        Toast.makeText(SignupActivity.this,"Failed to Register the User",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}