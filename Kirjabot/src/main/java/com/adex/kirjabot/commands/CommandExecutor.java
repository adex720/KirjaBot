package com.adex.kirjabot.commands;

import com.adex.kirjabot.Kirjabot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class CommandExecutor extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getMessage().getAuthor().isBot()) return;

        for(Command command : Kirjabot.COMMANDS){
            String viesti = event.getMessage().getContentRaw();
            String komento = command.getCommand();
            if(viesti.startsWith(komento)){
                command.execute(event);
            }
        }
    }
}
