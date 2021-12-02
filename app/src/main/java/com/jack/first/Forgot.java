package com.jack.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
    }

    public void onClick(View v) {
        Intent intent = new Intent(Forgot.this, LoginActivity.class);
        Toast toast = Toast.makeText(this,"Password recovery instructions sent",Toast.LENGTH_LONG );
        toast.show();
        startActivity(intent);
    }
}