package com.adex.kirjabot.classes;

import com.adex.kirjabot.util.Kirja;

import java.util.ArrayList;

public class Kirjat {

    public static final ArrayList<Kirja> KIRJAT = new ArrayList<>();

    public static Kirja get(String lukija){
        for(Kirja kirja : KIRJAT){
            if(kirja.getLukija().equalsIgnoreCase(lukija)) return kirja;
        }
        return null;
    }
}
