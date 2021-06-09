package com.raj_shah.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView tvname,tvemail,tvmobile;
    Button btnlogout;
    SharedPreferences preferences;

    public static final String main_key="my_pref";
    public static final String name_key="namekey";
    public static final String email_key="emailkey";
    public static final String mobile_key="mobilekey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvname=findViewById(R.id.tvname);
        tvemail=findViewById(R.id.tvemail);
        tvmobile=findViewById(R.id.tvmobile);

        btnlogout=findViewById(R.id.btnlogout);

        preferences=getSharedPreferences(main_key,MODE_PRIVATE);

        String name=preferences.getString(name_key,"");
        String email=preferences.getString(email_key,"");
        String mobile=preferences.getString(mobile_key,"");

        tvname.setText(name);
        tvemail.setText(email);
        tvmobile.setText(mobile);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=preferences.edit();

                editor.clear();
                editor.commit();

                finish();

                moveTaskToBack(true);
            }
        });
    }
}