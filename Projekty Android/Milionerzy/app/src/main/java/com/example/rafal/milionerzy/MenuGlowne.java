package com.example.rafal.milionerzy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuGlowne extends AppCompatActivity {
    Button b6;
    Context context;
    MediaPlayer piosenka;

    @Override
    public void onBackPressed() { }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        piosenka=MediaPlayer.create(this, R.raw.piosenka);
        piosenka.start();
        b6 = (Button) findViewById(R.id.button3);
        b6.setBackgroundResource(R.drawable.menu);
        View.OnClickListener l = new View.OnClickListener(){
            public void onClick(View v){
                piosenka.stop();
                context=getApplicationContext();

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        };
        b6.setOnClickListener(l);
    }
}
