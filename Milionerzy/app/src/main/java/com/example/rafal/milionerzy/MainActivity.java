package com.example.rafal.milionerzy;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();

    MediaPlayer mysound;
    MediaPlayer mysound2;
    MediaPlayer mysound3;
    MediaPlayer mysound4;
    MediaPlayer mysound5;
    Context context;
    ImageView zakaz;
    ImageView zakaz2;
    ImageView zakaz3;
    ImageView odpowiedz_test;
    int losowa;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b7;
    Button b8;
    Button b9;
    Button b10;
    TextView t1;
    TextView t2;
    int d = 0;
    int i;
    Pytania pytania = new Pytania();
    Punktacja punkt = new Punktacja();
    Odpowiedzi odpowiedz = new Odpowiedzi();
    final Handler handler = new Handler();
    LosowanieBezPowtorzenZeSprawdzaniem los = new LosowanieBezPowtorzenZeSprawdzaniem(39);


    @Override
    public void onBackPressed() {
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mysound = MediaPlayer.create(this, R.raw.piosenka);
        mysound2 = MediaPlayer.create(this, R.raw.melodia_zaznacz);
        mysound3 = MediaPlayer.create(this, R.raw.dobra_odpowiedz);
        mysound4 = MediaPlayer.create(this, R.raw.poczatek);
        mysound5 = MediaPlayer.create(this, R.raw.przegrana);
        mysound4.start();
        odpowiedz_test = (ImageView) findViewById(R.id.imageView);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button5);
        b4 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button4);
        b10 = (Button) findViewById(R.id.button9);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        zakaz = (ImageView) findViewById(R.id.imageView7);
        zakaz2 = (ImageView) findViewById(R.id.imageView8);
        zakaz3 = (ImageView) findViewById(R.id.imageView9);
        pytania.pytanka();
        nastepnePytanie();

    }


    View.OnClickListener myhandler1 = new View.OnClickListener() {
        public void onClick(View v) {
            if (b1.getText().equals(pytania.getOdpowiedzi(i, 5))) {
                // punkt.DodajPunkt();
                mysound2.start();
                b1.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b1.setBackgroundResource(R.drawable.odobra);
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To poprawna odpowiedź !");
                        mysound3.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        odblokuj();
                        nastepnePytanie();
                    }
                }, 8000);
            } else {
                mysound2.start();
                b1.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b1.setBackgroundResource(R.drawable.ozla);
                        zla_odpowiedz();
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To zła odpowiedź !");
                        mysound5.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mysound.stop();
                        odblokuj();
                        context = getApplicationContext();
                        Intent intent = new Intent(context, MenuGlowne.class);
                        startActivity(intent);
                    }
                }, 8000);

            }
        }
    };

    View.OnClickListener myhandler2 = new View.OnClickListener() {
        public void onClick(View v) {
            if (b2.getText().equals(pytania.getOdpowiedzi(i, 5))) {
                // punkt.DodajPunkt();
                mysound2.start();
                b2.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b2.setBackgroundResource(R.drawable.odobra);
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To poprawna odpowiedź !");
                        mysound3.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        odblokuj();
                        nastepnePytanie();
                    }
                }, 8000);
            } else {
                mysound2.start();
                b2.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b2.setBackgroundResource(R.drawable.ozla);
                        zla_odpowiedz();
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To zła odpowiedź !");
                        mysound5.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mysound.stop();
                        odblokuj();
                        context = getApplicationContext();
                        Intent intent = new Intent(context, MenuGlowne.class);
                        startActivity(intent);
                    }
                }, 8000);
            }
        }
    };

    View.OnClickListener myhandler3 = new View.OnClickListener() {
        public void onClick(View v) {
            if (b3.getText().equals(pytania.getOdpowiedzi(i, 5))) {
                // punkt.DodajPunkt();
                mysound2.start();
                b3.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b3.setBackgroundResource(R.drawable.odobra);
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To poprawna odpowiedź !");
                        mysound3.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        odblokuj();
                        nastepnePytanie();
                    }
                }, 8000);
            } else {
                mysound2.start();
                b3.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b3.setBackgroundResource(R.drawable.ozla);
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To zła odpowiedź !");
                        zla_odpowiedz();
                        mysound5.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mysound.stop();
                        odblokuj();
                        context = getApplicationContext();
                        Intent intent = new Intent(context, MenuGlowne.class);
                        startActivity(intent);
                    }
                }, 8000);
            }
        }
    };

    View.OnClickListener myhandler4 = new View.OnClickListener() {
        public void onClick(View v) {
            if (b4.getText().equals(pytania.getOdpowiedzi(i, 5))) {
                mysound2.start();
                //  punkt.DodajPunkt();
                b4.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b4.setBackgroundResource(R.drawable.odobra);
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To poprawna odpowiedź !");
                        mysound3.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        odblokuj();
                        nastepnePytanie();
                    }
                }, 8000);
            } else {
                mysound2.start();
                b4.setBackgroundResource(R.drawable.opomarancz);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        b4.setBackgroundResource(R.drawable.ozla);
                        t2.setVisibility(View.VISIBLE);
                        t2.setText("To zła odpowiedź !");
                        zla_odpowiedz();
                        mysound5.start();
                    }
                }, 2000);
                zawies();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mysound.stop();
                        odblokuj();
                        context = getApplicationContext();
                        Intent intent = new Intent(context, MenuGlowne.class);
                        startActivity(intent);
                    }
                }, 8000);
            }
        }
    };

    View.OnClickListener myhandler5 = new View.OnClickListener() {
        public void onClick(View v) {
            polowka();
        }
    };


    void nastepnePytanie() {
        d++;
        if (punkt.PokazPunkt(d) > 1000000) {
            context = getApplicationContext();
            Intent intent = new Intent(context, Milioner.class);
            startActivity(intent);
        }
        b9.setText("Pytanie za: " + punkt.PokazPunkt(d) + "zł");
        t2.setVisibility(View.INVISIBLE);
        i = los.get();
        t1.setText(pytania.getPytanie(i));
        b1.setText(pytania.getOdpowiedzi(i, 1));
        b2.setText(pytania.getOdpowiedzi(i, 2));
        b3.setText(pytania.getOdpowiedzi(i, 3));
        b4.setText(pytania.getOdpowiedzi(i, 4));
        b1.setBackgroundResource(R.drawable.onormalna);
        b2.setBackgroundResource(R.drawable.onormalna);
        b3.setBackgroundResource(R.drawable.onormalna);
        b4.setBackgroundResource(R.drawable.onormalna);
        b1.setOnClickListener(myhandler1);
        b2.setOnClickListener(myhandler2);
        b3.setOnClickListener(myhandler3);
        b4.setOnClickListener(myhandler4);
        b7.setOnClickListener(myhandler5);
        b8.setOnClickListener(myhandler6);
        b10.setOnClickListener(myhandler7);
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);


    }

    void zawies() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }


    void odblokuj() {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    void polowka() {
        b7.setEnabled(false);
        zakaz.setVisibility(View.VISIBLE);
        if (b1.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            do {
                losowa = random.nextInt(3) + 1;

                if (losowa == 2) {
                    b3.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                }
                if (losowa == 3) {
                    b2.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                }
                if (losowa == 4) {
                    b2.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                }
            } while (losowa == 1);
        }
        //---------------------------------------------------------------
        if (b2.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            do {
                losowa = random.nextInt(3) + 1;

                if (losowa == 1) {
                    b3.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                }
                if (losowa == 3) {
                    b1.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                }
                if (losowa == 4) {
                    b1.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                }
            } while (losowa == 2);
        }
        //---------------------------------------------------------------
        if (b3.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            do {
                losowa = random.nextInt(3) + 1;

                if (losowa == 1) {
                    b2.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                }
                if (losowa == 2) {
                    b1.setVisibility(View.INVISIBLE);
                    b4.setVisibility(View.INVISIBLE);
                }
                if (losowa == 4) {
                    b1.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                }


            } while (losowa == 3);
        }
        //---------------------------------------------------------------
        if (b4.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            do {
                losowa = random.nextInt(3) + 1;

                if (losowa == 1) {
                    b2.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                }
                if (losowa == 2) {
                    b1.setVisibility(View.INVISIBLE);
                    b3.setVisibility(View.INVISIBLE);
                }
                if (losowa == 3) {
                    b1.setVisibility(View.INVISIBLE);
                    b2.setVisibility(View.INVISIBLE);
                }
            } while (losowa == 4);
        }
    }

    View.OnClickListener myhandler6 = new View.OnClickListener() {
        public void onClick(View v) {
            telefon();
        }
    };

    View.OnClickListener myhandler7 = new View.OnClickListener() {
        public void onClick(View v) {
            publicznosc();
        }
    };

    void telefon() {
        losowa = random.nextInt(8) + 1;

        if (b1.getText().equals(pytania.getOdpowiedzi(i, 5)))
            t1.setText(odpowiedz.getOdpowiedz(losowa) + "A");
        if (b2.getText().equals(pytania.getOdpowiedzi(i, 5)))
            t1.setText(odpowiedz.getOdpowiedz(losowa) + "B");
        if (b3.getText().equals(pytania.getOdpowiedzi(i, 5)))
            t1.setText(odpowiedz.getOdpowiedz(losowa) + "C");
        if (b4.getText().equals(pytania.getOdpowiedzi(i, 5)))
            t1.setText(odpowiedz.getOdpowiedz(losowa) + "D");
        if (losowa >= 5 && losowa <= 8)
            t1.setText(odpowiedz.getOdpowiedz(losowa));
        b8.setEnabled(false);
        zakaz2.setVisibility(View.VISIBLE);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                t1.setText(pytania.getOdpowiedzi(i, 0));
            }
        }, 6000);
    }

    void publicznosc() {
        b10.setEnabled(false);
        zakaz3.setVisibility(View.VISIBLE);
        if (b1.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            t1.setVisibility(View.INVISIBLE);
            odpowiedz_test.setImageResource(R.drawable.odpowiedz_a1);
            odpowiedz_test.setVisibility(View.VISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    t1.setVisibility(View.VISIBLE);
                    odpowiedz_test.setVisibility(View.INVISIBLE);
                }
            }, 6000);
        }
        //-----------------------
        if (b2.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            t1.setVisibility(View.INVISIBLE);
            odpowiedz_test.setImageResource(R.drawable.odpowiedz_b1);
            odpowiedz_test.setVisibility(View.VISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    t1.setVisibility(View.VISIBLE);
                    odpowiedz_test.setVisibility(View.INVISIBLE);
                }
            }, 6000);
        }
        if (b3.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            t1.setVisibility(View.INVISIBLE);
            odpowiedz_test.setImageResource(R.drawable.odpowiedz_c1);
            odpowiedz_test.setVisibility(View.VISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    t1.setVisibility(View.VISIBLE);
                    odpowiedz_test.setVisibility(View.INVISIBLE);
                }
            }, 6000);
        }
        if (b4.getText().equals(pytania.getOdpowiedzi(i, 5))) {
            t1.setVisibility(View.INVISIBLE);
            odpowiedz_test.setImageResource(R.drawable.odpowiedz_d1);
            odpowiedz_test.setVisibility(View.VISIBLE);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    t1.setVisibility(View.VISIBLE);
                    odpowiedz_test.setVisibility(View.INVISIBLE);
                }
            }, 6000);
        }
    }

    void zla_odpowiedz(){
        if (b1.getText().equals(pytania.getOdpowiedzi(i, 5))){
            b1.setBackgroundResource(R.drawable.odobra);
        }
        if (b2.getText().equals(pytania.getOdpowiedzi(i, 5))){
            b2.setBackgroundResource(R.drawable.odobra);
        }
        if (b3.getText().equals(pytania.getOdpowiedzi(i, 5))){
            b3.setBackgroundResource(R.drawable.odobra);
        }
        if (b4.getText().equals(pytania.getOdpowiedzi(i, 5))){
            b4.setBackgroundResource(R.drawable.odobra);
        }
    }
}



