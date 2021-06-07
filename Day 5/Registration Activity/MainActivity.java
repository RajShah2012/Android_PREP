package com.raj_shah.registrationactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText etname,etemail,etmoblie,etpassword;
    RadioButton rbmale,rbfemale,rbother;
    CheckBox cbprogramming,cbtesting,cbhacking,cbdatabase;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname=findViewById(R.id.etname);
        etemail=findViewById(R.id.etemail);
        etmoblie=findViewById(R.id.etmobile);
        etpassword=findViewById(R.id.etpassword);

        rbmale=findViewById(R.id.rbmale);
        rbfemale=findViewById(R.id.rbfemale);
        rbother=findViewById(R.id.rbother);

        cbprogramming=findViewById(R.id.cbprogramming);
        cbtesting=findViewById(R.id.cbtesting);
        cbhacking=findViewById(R.id.cbhacking);
        cbdatabase=findViewById(R.id.cbdatabase);

        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Do you want to submit the above information ?");

                alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=etname.getText().toString();
                        String email=etemail.getText().toString();
                        String mobile=etmoblie.getText().toString();
                        String password=etpassword.getText().toString();

                        String radiogroupresult="";
                        if(rbmale.isChecked()){
                            radiogroupresult="Male";
                        }
                        if(rbfemale.isChecked()){
                            radiogroupresult="Female";
                        }
                        if(rbother.isChecked()){
                            radiogroupresult="Other";
                        }

                        String checkboxresult="";
                        if(cbprogramming.isChecked()){
                            checkboxresult +=  "Programming\n";
                        }
                        if(cbtesting.isChecked()){
                            checkboxresult +=  "Testing\n";
                        }
                        if(cbhacking.isChecked()){
                            checkboxresult +=  "Hacking\n";
                        }
                        if(cbdatabase.isChecked()){
                            checkboxresult +=  "Database Management\n";
                        }

                        Intent intent=new Intent(MainActivity.this,DataActivity.class);

                        intent.putExtra("NAME",name);
                        intent.putExtra("EMAIL",email);
                        intent.putExtra("MOBILE",mobile);
                        intent.putExtra("PASSWORD",password);

                        intent.putExtra("RADIOGROUPRESULT",radiogroupresult);

                        intent.putExtra("CHECKBOXRESULT",checkboxresult);

                        startActivity(intent);
                    }
                });

                alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog=alertDialogBuilder.create();
                alertDialog.setTitle("Alert");
                alertDialog.show();
            }
        });
    }
}