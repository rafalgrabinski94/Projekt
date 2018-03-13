package com.example.rafal.milionerzy;

/**
 * Created by Rafal on 21.02.2017.
 */

public class LosowanieBezPowtorzenZeSprawdzaniem {

    private boolean[] liczby;


    private int size;


    public LosowanieBezPowtorzenZeSprawdzaniem(int size) {

        liczby = new boolean[size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            liczby[i] = true;
        }
    }

    public int get() {

        int i = (int) (Math.random() * this.size) + 1;

        if (liczby[i - 1] == true) {

            liczby[i - 1] = false;
            return i;
        } else {

            return get();
        }
    }

}
