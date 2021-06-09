package com.raj_shah.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etmobile,etmessage;
    Button btnsend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etmobile=findViewById(R.id.etmobile);
        etmessage=findViewById(R.id.etmessage);

        btnsend=findViewById(R.id.btnsend);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile=etmobile.getText().toString();
                String message=etmessage.getText().toString();

                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(mobile, null, message, null, null);

                Toast.makeText(getApplicationContext(), "Message Sent Successfully", Toast.LENGTH_LONG).show();
            }
        });
    }
}