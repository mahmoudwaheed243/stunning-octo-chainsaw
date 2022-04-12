package com.example.collegeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    WebView webView1 ;
    Button gpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        webView1 = (WebView) findViewById(R.id.webview);
        webView1.setWebViewClient(new WebViewClient());
        WebSettings webSetting = webView1.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setAllowContentAccess(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setLoadsImagesAutomatically(true);
        webSetting.setAppCacheEnabled(true);
        gpa =findViewById(R.id.button6);
        gpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(HomeActivity.this , alculatro.class);
                startActivity(in);
            }
        });
    }
    public void onButtonClicke(View v){
        if (((Button) v).getId()==R.id.button1){
            //https://science.asu.edu.eg/ar/news
            webView1.loadUrl("https://science.asu.edu.eg/ar/news");
        }
        else if (((Button) v).getId()==R.id.button2){
            //https://science.asu.edu.eg/ar/events
            webView1.loadUrl("https://science.asu.edu.eg/ar/events");
        }
        else if (((Button) v).getId()==R.id.button3){
            //https://science.asu.edu.eg/ar/announcements
            webView1.loadUrl("https://science.asu.edu.eg/ar/announcements");
        }
        else if (((Button) v).getId()==R.id.button4){
            webView1.loadUrl("https://www.facebook.com/FacultyofScienceASU/");
        }
        else if (((Button) v).getId()==R.id.button5){
            webView1.loadUrl("https://forms.office.com/pages/responsepage.aspx?id=ZVH5axNBiEGbe8tsDBmKW-cPAmuMx6dNvjiN17RIMfRUMkRPR0xUMldPOEcwQUNFN1lKUEZLNk9XMy4u");
        }
        else if (((Button) v).getId()==R.id.button7){
            webView1.loadUrl("https://science.asu.edu.eg/ar");
        }
    }
    @Override
    public void onBackPressed(){
        if(webView1.canGoBack()){
            webView1.goBack();
        }
        else{
            webView1.loadUrl("https://science.asu.edu.eg/ar");
        }

    }
}