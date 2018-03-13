package com.example.rafal.wisiolec;

/**
 * Created by Rafal on 15.03.2017.
 */

public class LosowanieBezPowtorzenZeSprawdzaniem {
    // tablica bitów przechowująca liczby
    private boolean[] liczby;

    // aktulna wielkość tablicy
    private int size;

    // konstruktor przyjmuje jako argument wielkość zbioru
    public LosowanieBezPowtorzenZeSprawdzaniem(int size) {
        // tworzymy tablicę bitów
        liczby = new boolean[size];
        this.size = size;
        // Wypełniamy ją danymi
        for (int i = 0; i < size; i++) {
            liczby[i] = true;
        }
    }

    public int get() {
        // losujemy liczbę
        int i = (int) (Math.random() * this.size) + 1;

        // sprawdzamy czy taką liczbę już wylosowano jeżeli na pozycji i-tej
        // znajduje się true to znaczy, że liczba nie była wylosowana
        if (liczby[i - 1] == true) {
            // oznaczmy liczbę jako wylosowaną
            liczby[i - 1] = false;
            return i; // zwracamy liczbę
        } else {
            // liczba się powtórzyła. Ponawiamy losowanie
            return get();
        }
    }
}
