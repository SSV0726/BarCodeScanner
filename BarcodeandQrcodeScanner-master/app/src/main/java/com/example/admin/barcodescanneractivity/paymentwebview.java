package com.example.admin.barcodescanneractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class paymentwebview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentwebview);


        WebView browser = (WebView) findViewById(R.id.webview);
        browser.setWebViewClient(new WebViewClient());
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        browser.loadUrl("https://www.payumoney.com/paybypayumoney/#/D0F9E5706170BC66A829E06BE80B3630'");
    }
}