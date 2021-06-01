package com.raj_shah.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvAns;
    EditText et1,et2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    int ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAns=findViewById(R.id.tvAns);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);

        btnAdd=findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnSub=findViewById(R.id.btnSub);
        btnSub.setOnClickListener(this);
        btnMul=findViewById(R.id.btnMul);
        btnMul.setOnClickListener(this);
        btnDiv=findViewById(R.id.btnDiv);
        btnDiv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                String no1=et1.getText().toString();
                int a=Integer.parseInt(no1);
                String no2=et2.getText().toString();
                int b=Integer.parseInt(no2);
                ans=a+b;
                tvAns.setText(Integer.toString(ans));
                break;

            case R.id.btnSub:
                String no3=et1.getText().toString();
                int c=Integer.parseInt(no3);
                String no4=et2.getText().toString();
                int d=Integer.parseInt(no4);
                ans=c-d;
                tvAns.setText(Integer.toString(ans));
                break;

            case R.id.btnMul:
                String no5=et1.getText().toString();
                int e=Integer.parseInt(no5);
                String no6=et2.getText().toString();
                int f=Integer.parseInt(no6);
                ans=e*f;
                tvAns.setText(Integer.toString(ans));
                break;

            case R.id.btnDiv:
                String no7=et1.getText().toString();
                int g=Integer.parseInt(no7);
                String no8=et2.getText().toString();
                int h=Integer.parseInt(no8);
                ans=g/h;
                tvAns.setText(Integer.toString(ans));
                break;
        }
    }
}