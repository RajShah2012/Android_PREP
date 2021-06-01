package com.raj_shah.demoprep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URL_Activity extends AppCompatActivity {
    TextInputEditText link;
    AppCompatButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_url);

        link=findViewById(R.id.link);
        
        btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(view -> {
            if (checkUrl()){
                Intent intent=new Intent(URL_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkUrl() {
        boolean isUrlValid=false;
        String url=link.getText().toString().trim();

        if (link.getText().toString().trim().length()<=0){
            link.setError("Enter URL!");
        }
        else if (Patterns.WEB_URL.matcher(url).matches()){
            isUrlValid=true;
        }
        else {
            link.setError("Enter valid URL!");
        }

        return isUrlValid;
    }
}