package com.adex.kirjabot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public abstract class Command {

    private final String command;
    private final String name;
    private final String description;
    private final String usage;

    public Command(String command, String name, String description, String usage) {
        this.command = command;
        this.name = name;
        this.description = description;
        this.usage = usage;
    }

    public boolean execute(MessageReceivedEvent event){
        return true;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUsage() {
        return usage;
    }
}
