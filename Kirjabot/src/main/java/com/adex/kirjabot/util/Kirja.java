package com.adex.kirjabot.util;

public class Kirja {

    private final String nimi;
    private final String lukija;
    private final String kirjailija;
    private final int sivut;

    public Kirja(String nimi, String lukija, String kirjailija, int sivut) {
        this.nimi = nimi;
        this.lukija = lukija;
        this.kirjailija = kirjailija;
        this.sivut = sivut;
    }

    public String getnimi() {
        return nimi;
    }

    public String getLukija() {
        return lukija;
    }

    public int getSivut() {
        return sivut;
    }

    public String getKirjailija() {
        return kirjailija;
    }

    @Override
    public String toString() {
        return lukija + ": " + nimi + ", " + kirjailija + "; " + sivut + " sivua";
    }
}
