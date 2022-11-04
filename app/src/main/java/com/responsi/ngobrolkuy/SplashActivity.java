package com.responsi.ngobrolkuy;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    private Intent splash;

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        

        splash = new Intent(SplashActivity.this, LoginActivity.class);

            startActivity(splash);
        };
    }
