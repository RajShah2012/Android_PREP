package com.raj_shah.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ImageView ivimage;
    TextView tvname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivimage=findViewById(R.id.ivimage);
        tvname=findViewById(R.id.tvname);

        Intent intent=getIntent();
        int image=intent.getIntExtra("image",R.drawable.b);
        ivimage.setImageResource(image);
        String name=intent.getStringExtra("name");
        tvname.setText(name);
    }
}