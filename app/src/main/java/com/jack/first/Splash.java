package com.jack.first;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp(true);


        ImageView bgskyline = (ImageView) findViewById(R.id.nyskyline);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        bgskyline.startAnimation(myanim);

        Glide.with(this)
                .load(R.drawable.nyskyline)
                .into(bgskyline);

        ImageView palogsplash = (ImageView) findViewById(R.id.splashlog);
        Animation myanim2 = AnimationUtils.loadAnimation(this, R.anim.fadein);
        palogsplash.startAnimation(myanim2);

        Glide.with(this)
                .load(R.mipmap.ic_palog_foreground)
                .into(palogsplash);

    }

    private void openApp (boolean locationPermission) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (Splash.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 3500);
    }

    public void openLogin(View v) {
        Intent intent = new Intent(Splash.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}