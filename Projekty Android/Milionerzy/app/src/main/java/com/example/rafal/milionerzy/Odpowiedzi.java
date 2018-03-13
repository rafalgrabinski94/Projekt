package com.example.rafal.milionerzy;

/**
 * Created by Rafal on 24.02.2017.
 */

public class Odpowiedzi {
    String tab[]=new String[50];

    Odpowiedzi(){
        tab[1]="Hmm... Moim zdaniem jest to: ";
        tab[2]="To z pewnością jest odpowiedź: ";
        tab[3]="Nie wiem czy dobrze myślę ale to chyba chodzi o odpowiedź: ";
        tab[4]="Ciężkie pytanie, ale znam na nie odpowiedź ! To będzie: ";
        tab[5]="Nie doniosę Ci... absolutnie.";
        tab[6]="Za dużo chciałbyś wiedziec.";
        tab[7]="Nie mam pojęcia o czym do mnie mówisz, nie chce Tobie źle doradzić.";
        tab[8]="Nie wiem..hmmm..może to będzie..pss nie wiem niestety :-(";
    }

    String getOdpowiedz(int i){
        return tab[i];
    }
}
