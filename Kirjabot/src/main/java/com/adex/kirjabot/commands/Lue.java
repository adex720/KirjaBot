package com.adex.kirjabot.commands;

import com.adex.kirjabot.Kirjabot;
import com.adex.kirjabot.Loader;
import com.adex.kirjabot.util.Lukija;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Lue extends Command{

    public Lue() {
        super(Kirjabot.PREFIX + "lue","lue","Asettaa nykyisen sivusi.",Kirjabot.PREFIX + "lue <sivu>");
    }

    @Override
    public boolean execute(MessageReceivedEvent event) {
        long lukijaId = event.getAuthor().getIdLong();
        Lukija lukija = Lukija.get(lukijaId);
        if(lukija == null){
            event.getTextChannel().sendMessage("Sinulla ei ole keskeneräistä kirjaa.").queue();
            return true;
        }

        int sivu;

        try{
            sivu = Integer.parseInt(event.getMessage().getContentRaw().substring(5));
        } catch (NumberFormatException e){
            e.printStackTrace();
            event.getTextChannel().sendMessage("Kerrohan mille sivulle olet lukenut!").queue();
            return true;
        }

        lukija.getKirja().setNykyinenSivu(sivu);
        Loader.paivitaKirja(event.getAuthor().getIdLong(), Lukija.get(event.getAuthor().getIdLong()).getNimi(), sivu);
        event.getTextChannel().sendMessage("Luettujen sivujen määrä päivitetty onnistuneesti.").queue();
        return true;
    }
}
