package com.adex.kirjabot.commands;

import com.adex.kirjabot.Kirjabot;
import com.adex.kirjabot.Loader;
import com.adex.kirjabot.util.Kirja;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ListaaKirjat extends Command{

    public ListaaKirjat() {
        super(Kirjabot.PREFIX + "listaa","listaa","Listaa kaikki kirjat, niiden kirjoittajat sekä sivumäärän.",Kirjabot.PREFIX + "listaa");
    }

    @Override
    public boolean execute(MessageReceivedEvent event) {
        for(Kirja kirja : Loader.KIRJAT){
            event.getTextChannel().sendMessage(kirja + "\n").queue();
        }

        return true;
    }
}
