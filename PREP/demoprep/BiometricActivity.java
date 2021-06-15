package com.raj_shah.demoprep;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import java.util.concurrent.Executor;

public class BiometricActivity extends AppCompatActivity {
    TextView tvmsg;
    AppCompatButton btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_biometric);

        tvmsg = findViewById(R.id.tvmsg);
        btnVerify = findViewById(R.id.btnVerify);

        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
            case BiometricManager.BIOMETRIC_SUCCESS:
                tvmsg.setText("You can use the fingerprint sensor to login");
                tvmsg.setTextColor(Color.parseColor("#24a0fc"));
                break;

            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                tvmsg.setText("This device don't have a fingerprint sensor");
                btnVerify.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                tvmsg.setText("The biometric sensors is currently unavailable");
                btnVerify.setVisibility(View.GONE);
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                tvmsg.setText("Your device don't have any fingerprint saved, please check your security settings");
                btnVerify.setVisibility(View.GONE);
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(this);

        BiometricPrompt biometricPrompt = new BiometricPrompt(BiometricActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull @org.jetbrains.annotations.NotNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull @org.jetbrains.annotations.NotNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent intent = new Intent(BiometricActivity.this, HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder().setTitle("Login").setDescription("Use your fingerprint to login to your app").setNegativeButtonText("Cancel").build();

        btnVerify.setOnClickListener(view -> biometricPrompt.authenticate(promptInfo));
    }
}