package com.raj_shah.onclick_methods;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2=findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button 2 Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btn3=findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
    }

    public void showMessage(View view) {
        Toast.makeText(this, "Button 1 Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Button 3 Clicked", Toast.LENGTH_SHORT).show();
    }
}