package com.raj_shah.demoprep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

public class VerificationActivity extends AppCompatActivity {
    LinearLayout btnBiometrics,btnPIN;
    AppCompatButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verification);

        btnBiometrics=findViewById(R.id.btnBiometrics);
        btnBiometrics.setOnClickListener(view -> {
            Intent intent1=new Intent(VerificationActivity.this,BiometricActivity.class);
            startActivity(intent1);
        });

        btnPIN=findViewById(R.id.btnPIN);
        btnPIN.setOnClickListener(view -> {
            Intent intent2=new Intent(VerificationActivity.this,PINActivity.class);
            startActivity(intent2);
        });

        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(view -> {
            Intent intent=new Intent();
        });
    }
}