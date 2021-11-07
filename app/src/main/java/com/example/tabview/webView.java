package com.example.tabview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class webView extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    TextView toolbartv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        toolbar=findViewById(R.id.toolBar);
        toolbartv=toolbar.findViewById(R.id.toolbartv);
        webView=findViewById(R.id.WebView);
        setSupportActionBar(toolbar);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }
}