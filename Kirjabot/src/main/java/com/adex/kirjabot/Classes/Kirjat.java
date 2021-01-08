Package com.adex.kirjabot.classes;

import java.util.Arraylist;

public class Kirjat {

    public static final ArrayList<Kirja> KIRJAT = new ArrayList<>();
        
    public static Kirja get(String lukija){
        for(Kirja kirja : KIRJAT){
            if(kirja.getLukija().equalsIgnoreCase(lukija)) return kirja;
        }
        return null;
    }
}
