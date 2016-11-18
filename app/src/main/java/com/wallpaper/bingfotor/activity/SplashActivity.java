package com.wallpaper.bingfotor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.wallpaper.bingfotor.R;

/**
 * Created by Limuyang on 2016/11/18.
 */

public class SplashActivity extends AppCompatActivity {
    private static final int DELAY_TIME = 2500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.left_slide_in,R.anim.left_slide_out);
                finish();
            }
        },DELAY_TIME);
    }
}
