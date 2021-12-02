package com.jack.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //Sends user to Main activity
    public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    //Sends user to Signup activity
    public void onClick1(View v) {
        Intent intent = new Intent(LoginActivity.this, Signup.class);
        startActivity(intent);
    }

    //Sends user to Forgot activity
    public void onClick2(View v) {
        Intent intent = new Intent(LoginActivity.this, Forgot.class);
        startActivity(intent);
    }
}