package com.example.rafal.milionerzy;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Milioner extends AppCompatActivity {
Context context;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                context=getApplicationContext();
                Intent intent = new Intent(context, MenuGlowne.class);
                startActivity(intent);
            }
        }, 5000);
    }
}
