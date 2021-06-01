package com.raj_shah.senddatatootheractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {
    TextView tvname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        tvname=findViewById(R.id.tvname);

        Intent intent=getIntent();

        String name=intent.getStringExtra("NAME");

        tvname.setText("Welcome " + name);
    }
}