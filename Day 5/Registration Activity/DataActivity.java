package com.raj_shah.registrationactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    TextView tvname,tvemail,tvmobile,tvgender,tvhobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        tvname=findViewById(R.id.tvname);
        tvemail=findViewById(R.id.tvemail);
        tvmobile=findViewById(R.id.tvmobile);
        tvgender=findViewById(R.id.tvgender);
        tvhobbies=findViewById(R.id.tvhobbies);

        Intent intent=getIntent();

        String name=intent.getStringExtra("NAME");
        tvname.setText(name);
        String email=intent.getStringExtra("EMAIL");
        tvemail.setText(email);
        String mobile=intent.getStringExtra("MOBILE");
        tvmobile.setText(mobile);
        String gender=intent.getStringExtra("RADIOGROUPRESULT");
        tvgender.setText(gender);
        String hobbies=intent.getStringExtra("CHECKBOXRESULT");
        tvhobbies.setText(hobbies);
    }
}