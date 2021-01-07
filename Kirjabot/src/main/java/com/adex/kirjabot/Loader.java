package com.adex.kirjabot;

import com.adex.kirjabot.util.Kirja;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Loader {

    public final static ArrayList<Kirja> KIRJAT = new ArrayList<>();

    public static final HashMap<Integer, String> NIMET = new HashMap<>();

    public static void onInitialize() {
        NIMET.put(1, "Aapo");
        NIMET.put(2, "Juuso");
        NIMET.put(3, "Jan");
        NIMET.put(4, "Viljami");
        lataaKirjat();
    }

    public static void lataaKirjat() {
        ArrayList<JSONObject> kirjaLista = new ArrayList<>();


        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL url = cl.getResource("kirjat.json");
            assert url != null;
            File wordList = new File(url.getFile());

            Object obj = new JSONParser().parse(new FileReader(wordList));
            JSONObject kirjat = (JSONObject) obj;

            kirjaLista.add((JSONObject) kirjat.get(NIMET.get(1)));
            kirjaLista.add((JSONObject) kirjat.get(NIMET.get(2)));
            kirjaLista.add((JSONObject) kirjat.get(NIMET.get(3)));
            kirjaLista.add((JSONObject) kirjat.get(NIMET.get(4)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 1;
        for (JSONObject jsonObject : kirjaLista) {
            try {
                String nimi = jsonObject.get("nimi").toString();
                String kirjailija = jsonObject.get("kirjailija").toString();
                int sivut = Integer.parseInt(jsonObject.get("sivut").toString());

                KIRJAT.add(new Kirja(nimi, NIMET.get(i), kirjailija, sivut));
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
