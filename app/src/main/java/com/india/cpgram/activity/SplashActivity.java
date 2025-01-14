package com.india.cpgram.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.india.cpgram.R;
import com.india.cpgram.utils.SharePrefrence;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean loginStatus = SharePrefrence.isLogin(SplashActivity.this,"cpgram");
                if(loginStatus) {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },3000);

    }
}