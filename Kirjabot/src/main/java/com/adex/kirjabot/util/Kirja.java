package com.adex.kirjabot.util;

public class Kirja {

    private final String nimi;
    private final String lukija;
    private final String kirjailija;
    private final int sivut;
    private final int nykyinenSivu;

    public Kirja(String nimi, String lukija, String kirjailija, int sivut, int nykyinenSivu) {
        this.nimi = nimi;
        this.lukija = lukija;
        this.kirjailija = kirjailija;
        this.sivut = sivut;
        this.nykyinenSivu = nykyinenSivu;
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

    public int getNykyinenSivu() {
        return nykyinenSivu;
    }

    public String getKirjailija() {
        return kirjailija;
    }

    @Override
    public String toString() {
        return lukija + ": " + nimi + ", " + kirjailija + "; sivulla " + nykyinenSivu + "/" + sivu;
    }
}
