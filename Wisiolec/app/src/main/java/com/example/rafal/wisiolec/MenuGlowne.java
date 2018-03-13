package com.example.rafal.wisiolec;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuGlowne extends AppCompatActivity {

    Button zagraj;
    Button wyjdz;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_glowne);
        zagraj=(Button)findViewById(R.id.button);
        wyjdz=(Button)findViewById(R.id.button2);

        View.OnClickListener l = new View.OnClickListener(){
            public void onClick(View v){

                context=getApplicationContext();

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }

        };
        zagraj.setOnClickListener(l);

        View.OnClickListener m = new View.OnClickListener(){
            public void onClick(View v){

                //getActivity().finish();
                System.exit(0);
            }

        };
        wyjdz.setOnClickListener(m);



    }
}
