package com.raj_shah.sum_of_2_numbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText etno1,etno2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etno1=findViewById(R.id.etno1);
        etno2=findViewById(R.id.etno2);
        
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1=etno1.getText().toString();
                String num2=etno2.getText().toString();

                int a=Integer.parseInt(num1);
                int b=Integer.parseInt(num2);

                Toast.makeText(MainActivity.this, "Addition is :" + (a+b), Toast.LENGTH_LONG).show();
            }
        });
    }
}