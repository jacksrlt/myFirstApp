package com.jack.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onClick(View v) {
        Intent intent = new Intent(Signup.this, LoginActivity.class);
        Toast toast = Toast.makeText(this,"Confirm your email",Toast.LENGTH_LONG );
        toast.show();
        startActivity(intent);
    }
}