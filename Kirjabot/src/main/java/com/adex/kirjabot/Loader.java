package com.adex.kirjabot;

import com.adex.kirjabot.classes.Kirjat;
import com.adex.kirjabot.util.Kirja;
import com.adex.kirjabot.util.Lukija;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Loader {

    private final static String PATH = Dotenv.load().get("PATH");

    public static final HashMap<Integer, String> NIMET = new HashMap<>();

    public static JSONObject KIRJAT = null;

    public static void onInitialize() {
        NIMET.put(1, "Aapo");
        NIMET.put(2, "Juuso");
        NIMET.put(3, "Jan");
        NIMET.put(4, "Viljami");
        lataaKirjat();
    }

    public static void lataaKirjat() {
        ArrayList<JSONObject> kirjaLista = new ArrayList<>();

        //kirjat
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL url = cl.getResource("kirjat.json");
            assert url != null;
            File wordList = new File(url.getFile());

            Object obj = new JSONParser().parse(new FileReader(wordList));
            KIRJAT = (JSONObject) obj;

            kirjaLista.add((JSONObject) KIRJAT.get(NIMET.get(1)));
            kirjaLista.add((JSONObject) KIRJAT.get(NIMET.get(2)));
            kirjaLista.add((JSONObject) KIRJAT.get(NIMET.get(3)));
            kirjaLista.add((JSONObject) KIRJAT.get(NIMET.get(4)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = 1;
        for (JSONObject jsonObject : kirjaLista) {
            try {
                String nimi = jsonObject.get("nimi").toString();
                String kirjailija = jsonObject.get("kirjailija").toString();
                int sivut = Integer.parseInt(jsonObject.get("sivut").toString());
                int nykyinenSivu = Integer.parseInt(jsonObject.get("nykyinen").toString());

                Kirjat.KIRJAT.add(new Kirja(nimi, NIMET.get(i), kirjailija, sivut, nykyinenSivu));
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }


        //lukijat
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            URL url = cl.getResource("lukijat.json");
            assert url != null;
            File wordList = new File(url.getFile());

            Object obj = new JSONParser().parse(new FileReader(wordList));
            JSONObject lukijaTiedosto = (JSONObject) obj;


            for (int i2 = 1; true; i2++) {

                JSONObject lukija = (JSONObject) lukijaTiedosto.get("" + i2);

                if (lukija == null) return;

                try {
                    String nimi = lukija.get("nimi").toString();
                    int id = Integer.parseInt(lukija.get("id").toString());
                    long discordId = Long.parseLong(lukija.get("discord_id").toString());

                    Lukija.LUKIJAT.add(new Lukija(nimi, id, discordId, Kirjat.get(nimi)));
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void paivitaKirja(Long userID, String dNimi, int uusiSivu) {
        try {
            JSONObject vanha = KIRJAT;
            for (Lukija lukija : Lukija.LUKIJAT) {
                if (lukija.getDiscordId().equals(userID)) {
                    JSONObject vanhaKirja = (JSONObject) vanha.get(dNimi);

                    String nimi = vanhaKirja.get("nimi").toString();
                    String kirjailija = vanhaKirja.get("kirjailija").toString();
                    int sivut = Integer.parseInt(vanhaKirja.get("sivut").toString());
                    int nykyinenSivu = Integer.parseInt(vanhaKirja.get("nykyinen").toString());

                    HashMap<String, Object> map = new HashMap<>();
                    map.put("nimi" ,nimi);
                    map.put("kirjailija" ,kirjailija);
                    map.put("sivut" ,sivut);
                    map.put("nykyinen" ,uusiSivu);


                    JSONObject uusiKirja = new JSONObject(map);
                    vanha.put(dNimi, uusiKirja);

                    //tallennus
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();

                    File kirjat = new File(PATH + "kirjat.json");

                    FileWriter fileWriter = new FileWriter(kirjat);

                    fileWriter.write(vanha.toJSONString());
                    fileWriter.flush();
                    fileWriter.close();


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
