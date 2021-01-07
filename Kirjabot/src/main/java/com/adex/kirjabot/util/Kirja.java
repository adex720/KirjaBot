package com.adex.kirjabot.util;

public class Kirja {

    private final String nimi;
    private final String kirjailija;
    private final int sivut;

    public Kirja(String nimi, String kirjailija, int sivut) {
        this.nimi = nimi;
        this.kirjailija = kirjailija;
        this.sivut = sivut;
    }

    public String getnimi() {
        return nimi;
    }

    public int getSivut() {
        return sivut;
    }

    public String getKirjailija() {
        return kirjailija;
    }

    @Override
    public String toString() {
        return nimi + ", " + kirjailija + "; " + sivut + " sivua";
    }
}
