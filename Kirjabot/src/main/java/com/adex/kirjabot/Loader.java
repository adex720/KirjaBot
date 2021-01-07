package com.adex.kirjabot;

import com.adex.kirjabot.util.Kirja;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

public class Loader {

    public final static ArrayList<Kirja> KIRJAT = new ArrayList<>();

    public static void onInitialize(){
        lataaKirjat();
    }

    public static void lataaKirjat(){
        ArrayList<JSONObject> kirjaLista = new ArrayList<>();
        

        try{
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL url = cl.getResource("kirjat.json");
            assert url != null;
            File wordList = new File(url.getFile());

            Object obj = new JSONParser().parse(new FileReader(wordList));
            JSONObject kirjat = (JSONObject) obj;
            
            kirjaLista.add((JSONObject) kirjat.get("aapo"));
            kirjaLista.add((JSONObject) kirjat.get("juuso"));
            kirjaLista.add((JSONObject) kirjat.get("jan"));
            kirjaLista.add((JSONObject) kirjat.get("viljami"));
        } catch (Exception e){
            e.printStackTrace();
        }
        for (JSONObject jsonObject : kirjaLista){
            try {
                String nimi = jsonObject.get("nimi").toString();
                String kirjailija = jsonObject.get("kirjailija").toString();
                int sivut = Integer.parseInt(jsonObject.get("sivut").toString());

                KIRJAT.add(new Kirja(nimi, kirjailija, sivut));
            } catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}
