package com.raj_shah.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText etemail,etpassword;
    Button btnlogin,btnsignup;

    public static final String main_key="my_pref";
    public static final String email_key="emailkey";
    public static final String password_key="passwordkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail=findViewById(R.id.etemail);
        etpassword=findViewById(R.id.etpassword);

        btnlogin=findViewById(R.id.btnlogin);
        btnsignup=findViewById(R.id.btnsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=etemail.getText().toString();
                String password=etpassword.getText().toString();

                SharedPreferences preferences=getSharedPreferences(main_key,MODE_PRIVATE);

                String useremail=preferences.getString(email_key,"");
                String userpassword=preferences.getString(password_key,"");

                if (email.equals(useremail) && password.equals(userpassword)){
                    Intent intent=new Intent(LoginActivity.this,DisplayActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Invalid Login Details", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}