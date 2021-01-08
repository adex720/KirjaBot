package com.adex.kirjabot.util;

import java.util.ArrayList;

public class Lukija {

    public static final ArrayList<Lukija> LUKIJAT = new ArrayList<>();

    private final String nimi;
    private final int id;
    private final Long discordId;

    private Kirja kirja;

    public Lukija(String nimi, int id, Long discordId, Kirja kirja) {
        this.nimi = nimi;
        this.id = id;
        this.discordId = discordId;
        this.kirja = kirja;
    }

    public static Lukija get(int id){
        for(Lukija lukjia : LUKIJAT){
            if(lukjia.id == id) return lukjia;
        }

        return null;
    }

    public Long getDiscordId() {
        return discordId;
    }

    public static Lukija get(Long discordId){
        for(Lukija lukjia : LUKIJAT){
            if(lukjia.discordId.equals(discordId)) return lukjia;
        }

        return null;
    }

    public Kirja getKirja() {
        return kirja;
    }

    public String getNimi() {
        return nimi;
    }

    public static int getId(Long discordId) {
        for(Lukija lukija : LUKIJAT){
            if(lukija.getDiscordId().equals(discordId)){
                return lukija.id;
            }
        }

        return 0;
    }
}
