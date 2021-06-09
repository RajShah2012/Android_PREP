package com.raj_shah.gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView gvCourse;

    String course[]={"PHP","ANDROID","IOS","C","IONIC","ANGULAR","WORDPRESS","JAVA","C#","HTML","FIREBASE","C++","NODE JS","REACT JS","PYTHON","MAGENTO","BOOTSTRAP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvCourse=findViewById(R.id.gvCourse);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,course);

        gvCourse.setAdapter(arrayAdapter);

        gvCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, course[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}