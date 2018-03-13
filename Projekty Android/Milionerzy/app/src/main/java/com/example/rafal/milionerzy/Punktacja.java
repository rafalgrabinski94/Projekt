package com.example.rafal.milionerzy;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by Rafal on 22.02.2017.
 */

public class Punktacja {



    private int tab[]=new int[17];

    Punktacja(){
        tab[0]=0;
        tab[1]=100;
        tab[2]=200;
        tab[3]=300;
        tab[4]=500;
        tab[5]=1000;
        tab[6]=2000;
        tab[7]=4000;
        tab[8]=8000;
        tab[9]=16000;
        tab[10]=32000;
        tab[11]=64000;
        tab[12]=125000;
        tab[13]=250000;
        tab[14]=500000;
        tab[15]=1000000;
        tab[16]=1000002;

    }

    int PokazPunkt(int i){
        return tab[i++];
    }


    }

