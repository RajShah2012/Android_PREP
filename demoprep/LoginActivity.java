package com.raj_shah.demoprep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText etUsername,etPassword;
    Spinner spinner;
    AppCompatButton btnLogin;
    String user[]={"User","Customer","Agent","Designer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);

        spinner=findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(LoginActivity.this, android.R.layout.simple_list_item_1,user);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> {
            if (checkUsername() && checkPassword()){
                Intent intent=new Intent(LoginActivity.this, VerificationActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkUsername(){
        boolean isUsernameValid=false;

        if (etUsername.getText().toString().trim().length()<=0){
            etUsername.setError("Enter Name");
        }
        else {
            isUsernameValid=true;
        }

        return isUsernameValid;
    }

    private boolean checkPassword(){
        boolean isPasswordValid=false;

        if (etPassword.getText().toString().trim().length() <= 0){
            etPassword.setError("Enter Password");
        }
        else {
            isPasswordValid=true;
        }

        return isPasswordValid;
    }
}