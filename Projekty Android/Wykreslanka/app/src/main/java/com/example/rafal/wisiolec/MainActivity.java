package com.example.rafal.wisiolec;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String napis[] = {"a l a  m a  k o t a", "m y s z  d o  k o m p u t e r a", "k o t e k  j e s t  m a l y", "u c z e l n i a", "k l a w i a t u r a", "s t a d i o n  p i l k a r s k i", "m u c h a  n i e  s i a d a","l e k k o a t l e t y k a","a n t y t e r r o r y s t a","s z a n s a  n a  s u k c e s","d o t k l i w y  d o t y k","k o l o r o w e  k w i a t y","d o  w i d z e n i a","l e k a r z  r o d z i n n y","c h u s t e c z k a  d o  n o s a"};
    private char tablica[];
    char tablica2[];
    boolean tablicaprawdy[]=new boolean[100];
    TextView punkty,najlepszy_wynik;
    Button z, x, c, v, b, n, m, a, s, d, f, g, h, j, k, l, q, w, e, r, t, y, u, i, o, p,wyraz,zakoncz_gre;
    int punktacja=0,licznik_wyrazu=0;
    int losowa, licznik_bledow = 0, pomocnicza = 0;
    int probnik = 0;
    Context context;
    ImageView jeden, dwa, trzy, cztery, piec;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wyraz=(Button)findViewById(R.id.button3);
        a = (Button) findViewById(R.id.buttonA);
        b = (Button) findViewById(R.id.buttonB);
        c = (Button) findViewById(R.id.buttonC);
        d = (Button) findViewById(R.id.buttonD);
        e = (Button) findViewById(R.id.buttonE);
        f = (Button) findViewById(R.id.buttonF);
        g = (Button) findViewById(R.id.buttonG);
        h = (Button) findViewById(R.id.buttonH);
        i = (Button) findViewById(R.id.buttonI);
        j = (Button) findViewById(R.id.buttonJ);
        k = (Button) findViewById(R.id.buttonK);
        l = (Button) findViewById(R.id.buttonL);
        m = (Button) findViewById(R.id.buttonM);
        n = (Button) findViewById(R.id.buttonN);
        o = (Button) findViewById(R.id.buttonO);
        p = (Button) findViewById(R.id.buttonP);
        r = (Button) findViewById(R.id.buttonR);
        s = (Button) findViewById(R.id.buttonS);
        t = (Button) findViewById(R.id.buttonT);
        u = (Button) findViewById(R.id.buttonU);
        w = (Button) findViewById(R.id.buttonW);
        y = (Button) findViewById(R.id.buttonY);
        z = (Button) findViewById(R.id.buttonZ);
        q = (Button) findViewById(R.id.buttonQ);
        najlepszy_wynik=(TextView)findViewById(R.id.textView2);
        zakoncz_gre=(Button)findViewById(R.id.button4);
        zakoncz_gre.setVisibility(View.INVISIBLE);
        punkty=(TextView)findViewById(R.id.textView);
        jeden = (ImageView) findViewById(R.id.imageView2);
        dwa = (ImageView) findViewById(R.id.imageView3);
        trzy = (ImageView) findViewById(R.id.imageView4);
        cztery = (ImageView) findViewById(R.id.imageView5);
        piec = (ImageView) findViewById(R.id.imageView6);
odblokujPrzyciski();
znikanieWisielca();
        sharedPreferences = getSharedPreferences("com.example.guessmynumber",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //listenery
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        w.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
        q.setOnClickListener(this);
        odblokujPrzyciski();
        //-koniec listenerów
        odczytaj_dane();
        zakoncz_gre.setOnClickListener(lm);
        wybierzNapis(losowa);
        podmiana(losowa);

        for(int i=0;i<100;i++){
            tablicaprawdy[i]=false;
        }

    }
    View.OnClickListener lm = new View.OnClickListener(){
        public void onClick(View v){

            context=getApplicationContext();

            Intent intent = new Intent(context, MenuGlowne.class);
            startActivity(intent);
        }

    };


    void znikanieWisielca() {
 jeden.setVisibility(View.INVISIBLE);
        dwa.setVisibility(View.INVISIBLE);
        trzy.setVisibility(View.INVISIBLE);
        cztery.setVisibility(View.INVISIBLE);
        piec.setVisibility(View.INVISIBLE);
}

    void wybierzNapis(int i) {
        tablica = napis[i].toCharArray();
        tablica2 = Arrays.copyOf(tablica, tablica.length); //kopiowanie tablicy
    }

    void podmiana(int i) {
        for(int j=0;j<tablica2.length;j++){
            if(tablica2[j]==' '){
                tablica2[j]=' ';
            }else{
                tablica2[j]='_';
            }
        }
        wyraz.setText(String.valueOf(tablica2));
    }

    void odkodowanie(int iq, char ce){
        for(int jk=0;jk<tablica2.length;jk++){
            if(tablica[jk]==ce) {
                tablica2[jk] = ce;
                wyraz.setText(String.valueOf(tablica2));
                pomocnicza=1;
                //ustawianie klawiszy
                if(ce=='a'){
                    a.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[0]=true;

                }
                if(ce=='b'){
                    b.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[1]=true;

                }
                if(ce=='c'){
                    c.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[2]=true;

                }
                if(ce=='d'){
                    d.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[3]=true;

                }
                if(ce=='e'){
                    e.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[4]=true;

                }
                if(ce=='f'){
                    f.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[5]=true;

                }
                if(ce=='g'){
                    g.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[6]=true;

                }
                if(ce=='h'){
                    h.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[7]=true;

                }
                if(ce=='i'){
                    i.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[8]=true;

                }
                if(ce=='j'){
                    j.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[9]=true;

                }
                if(ce=='k'){
                    k.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[10]=true;

                }
                if(ce=='l'){
                    l.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[11]=true;

                }
                if(ce=='m'){
                    m.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[12]=true;

                }
                if(ce=='n'){
                    n.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[13]=true;

                }
                if(ce=='o'){
                    o.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[14]=true;

                }
                if(ce=='p'){
                    p.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[15]=true;

                }
                if(ce=='s'){
                    s.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[16]=true;

                }
                if(ce=='t'){
                    t.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[17]=true;

                }
                if(ce=='w'){
                    w.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[18]=true;

                }
                if(ce=='r'){
                    r.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[19]=true;

                }
                if(ce=='z'){
                    z.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[20]=true;

                }
                if(ce=='y'){
                    y.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[21]=true;

                }

                if(ce=='u'){
                    u.setBackgroundResource(R.drawable.dobra);
                    tablicaprawdy[22]=true;

                }
                //-------------------
            }
        }

        if(tablicaprawdy[0]==false && ce=='a'){
            a.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[1]==false && ce=='b'){
            b.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[2]==false && ce=='c'){
            c.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[3]==false && ce=='d'){
            d.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[4]==false && ce=='e'){
            e.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[5]==false && ce=='f'){
            f.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[6]==false && ce=='g'){
            g.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[7]==false && ce=='h'){
            h.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[8]==false && ce=='i'){
            i.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[9]==false && ce=='j'){
            j.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[10]==false && ce=='k'){
            k.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[11]==false && ce=='l'){
            l.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[12]==false && ce=='m'){
            m.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[13]==false && ce=='n'){
            n.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[14]==false && ce=='o'){
            o.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[15]==false && ce=='p'){
            p.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[16]==false && ce=='s'){
            s.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[17]==false && ce=='t'){
            t.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[18]==false && ce=='w'){
            w.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[19]==false && ce=='r'){
            r.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[20]==false && ce=='z'){
            z.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[21]==false && ce=='y'){
            y.setBackgroundResource(R.drawable.zla);
        }
        if(tablicaprawdy[22]==false && ce=='u'){
            u.setBackgroundResource(R.drawable.zla);
        }

        if(pomocnicza==0){
            ustaw_blad();
            odejmijPunkt();
        }else{
            dodajPunkt();
            if(punktacja>sharedPreferences.getInt("BestScore",0)){
                editor.putInt("BestScore",punktacja);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Pobito nowy rekord !",Toast.LENGTH_SHORT).show();
            }
        }
        pomocnicza=0;

        probnik=0;

        for(int g=0;g<tablica2.length;g++){
            if(tablica2[g]=='_'){
                probnik=+1;
            }
        }

        if(probnik==0){
            wygrana();
        }
        for(int i=0;i<100;i++){
            tablicaprawdy[i]=false;
        }

        punkty.setText("Wynik: "+punktacja);
    }

    void wygrana(){
        wyraz.setTextColor(Color.GREEN);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                odblokujPrzyciski();
                wyraz.setTextColor(Color.WHITE);
                znikanieWisielca();
                wybierzNapis(losowa);
                podmiana(losowa);
                licznik_bledow=0;
                licznik_wyrazu=licznik_wyrazu+1;
            }
        }, 4000);
if(punktacja>sharedPreferences.getInt("BestScore",0)){
    editor.putInt("BestScore",punktacja);
    editor.commit();
}
odblokujPrzyciski();
        if (licznik_wyrazu==10){
            wyraz.setText("Brawo wygrałeś !!!");
            zablokuj_przyciski();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    context=getApplicationContext();

                    Intent intent = new Intent(context, MenuGlowne.class);
                    startActivity(intent);
                }
            }, 4000);
        }
    }

    void ustaw_blad(){
        licznik_bledow=licznik_bledow+1;

        if(licznik_bledow==1) {
            jeden.setVisibility(View.VISIBLE);
        }
        if(licznik_bledow==2) {
            dwa.setVisibility(View.VISIBLE);
        }
        if(licznik_bledow==3) {
            trzy.setVisibility(View.VISIBLE);
        }
        if(licznik_bledow==4) {
            cztery.setVisibility(View.VISIBLE);
        }
        if(licznik_bledow==5) {
            piec.setVisibility(View.VISIBLE);

            zakoncz_gre.setVisibility(View.VISIBLE);
            zablokuj_przyciski();
            wyraz.setText("Niestety, przegrałeś");

        }
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonA:
                odkodowanie(losowa,'a');
                a.setEnabled(false);
                break;
            case R.id.buttonB:
                odkodowanie(losowa,'b');
                b.setEnabled(false);
                break;
            case R.id.buttonC:
                odkodowanie(losowa,'c');
                c.setEnabled(false);
                break;
            case R.id.buttonD:
                odkodowanie(losowa,'d');
                d.setEnabled(false);
                break;
            case R.id.buttonE:
                odkodowanie(losowa,'e');
                e.setEnabled(false);
                break;
            case R.id.buttonF:
                odkodowanie(losowa,'f');
                f.setEnabled(false);
                break;
            case R.id.buttonG:
                odkodowanie(losowa,'g');
                g.setEnabled(false);
                break;
            case R.id.buttonH:
                odkodowanie(losowa,'h');
                h.setEnabled(false);
                break;
            case R.id.buttonI:
                odkodowanie(losowa,'i');
                i.setEnabled(false);
                break;
            case R.id.buttonJ:
                odkodowanie(losowa,'j');
                j.setEnabled(false);
                break;
            case R.id.buttonK:
                odkodowanie(losowa,'k');
                k.setEnabled(false);
                break;
            case R.id.buttonL:
                odkodowanie(losowa,'l');
                l.setEnabled(false);
                break;
            case R.id.buttonM:
                odkodowanie(losowa,'m');
                m.setEnabled(false);
                break;
            case R.id.buttonN:
                odkodowanie(losowa,'n');
                n.setEnabled(false);
                break;
            case R.id.buttonO:
                odkodowanie(losowa,'o');
                o.setEnabled(false);
                break;
            case R.id.buttonP:
                odkodowanie(losowa,'p');
                p.setEnabled(false);
                break;
            case R.id.buttonQ:
                odkodowanie(losowa,'q');
                q.setEnabled(false);
                break;
            case R.id.buttonR:
                odkodowanie(losowa,'r');
                r.setEnabled(false);
                break;
            case R.id.buttonS:
                odkodowanie(losowa,'s');
                s.setEnabled(false);
                break;
            case R.id.buttonT:
                odkodowanie(losowa,'t');
                t.setEnabled(false);
                break;
            case R.id.buttonU:
                odkodowanie(losowa,'u');
                u.setEnabled(false);
                break;
            case R.id.buttonW:
                odkodowanie(losowa,'w');
                w.setEnabled(false);
                break;
            case R.id.buttonY:
                odkodowanie(losowa,'y');
                y.setEnabled(false);
                break;
            case R.id.buttonZ:
                odkodowanie(losowa,'z');
                z.setEnabled(false);
                break;
        }
    }

    void odblokujPrzyciski(){
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
        g.setEnabled(true);
        h.setEnabled(true);
        i.setEnabled(true);
        j.setEnabled(true);
        k.setEnabled(true);
        m.setEnabled(true);
        l.setEnabled(true);
        n.setEnabled(true);
        o.setEnabled(true);
        p.setEnabled(true);
        u.setEnabled(true);
        y.setEnabled(true);
        w.setEnabled(true);
        z.setEnabled(true);
        r.setEnabled(true);
        s.setEnabled(true);
        t.setEnabled(true);


            a.setBackgroundResource(R.drawable.klawisze);

            b.setBackgroundResource(R.drawable.klawisze);

            c.setBackgroundResource(R.drawable.klawisze);

            d.setBackgroundResource(R.drawable.klawisze);

            e.setBackgroundResource(R.drawable.klawisze);

            f.setBackgroundResource(R.drawable.klawisze);

            g.setBackgroundResource(R.drawable.klawisze);

            h.setBackgroundResource(R.drawable.klawisze);

            i.setBackgroundResource(R.drawable.klawisze);

            j.setBackgroundResource(R.drawable.klawisze);

            k.setBackgroundResource(R.drawable.klawisze);

            l.setBackgroundResource(R.drawable.klawisze);

            m.setBackgroundResource(R.drawable.klawisze);

            n.setBackgroundResource(R.drawable.klawisze);

            o.setBackgroundResource(R.drawable.klawisze);

            p.setBackgroundResource(R.drawable.klawisze);

            s.setBackgroundResource(R.drawable.klawisze);

            t.setBackgroundResource(R.drawable.klawisze);

            w.setBackgroundResource(R.drawable.klawisze);

            r.setBackgroundResource(R.drawable.klawisze);

            z.setBackgroundResource(R.drawable.klawisze);

            u.setBackgroundResource(R.drawable.klawisze);

            y.setBackgroundResource(R.drawable.klawisze);
        }


        void dodajPunkt(){
            punktacja+=10;
        }

        void odejmijPunkt(){
            punktacja-=5;
        }

        void zablokuj_przyciski(){
            a.setEnabled(false);
            b.setEnabled(false);
            c.setEnabled(false);
            d.setEnabled(false);
            e.setEnabled(false);
            f.setEnabled(false);
            g.setEnabled(false);
            h.setEnabled(false);
            i.setEnabled(false);
            j.setEnabled(false);
            k.setEnabled(false);
            m.setEnabled(false);
            l.setEnabled(false);
            n.setEnabled(false);
            o.setEnabled(false);
            p.setEnabled(false);
            u.setEnabled(false);
            y.setEnabled(false);
            w.setEnabled(false);
            z.setEnabled(false);
            r.setEnabled(false);
            s.setEnabled(false);
            t.setEnabled(false);
    }

    void odczytaj_dane(){
        najlepszy_wynik.setText("Najlepszy wynik: "+sharedPreferences.getInt("BestScore",0));
    }

    }