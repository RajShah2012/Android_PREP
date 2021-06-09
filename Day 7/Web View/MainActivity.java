package com.raj_shah.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etsearch;
    Button btnsearch;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etsearch=findViewById(R.id.etsearch);

        btnsearch=findViewById(R.id.btnsearch);

        webView=findViewById(R.id.webView);

        btnsearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsearch:
                String URL=etsearch.getText().toString();

                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new MyWebViewClient());
                webView.loadUrl(URL);

                break;
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}