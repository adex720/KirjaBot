package com.adex.kirjabot;

import com.adex.kirjabot.commands.Command;
import com.adex.kirjabot.commands.CommandExecutor;
import com.adex.kirjabot.commands.ListaaKirjat;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;

public class Kirjabot {

    public static final String PREFIX = "!";
    public static final ArrayList<Command> COMMANDS = new ArrayList<>();

    
    private static final Dotenv dotenv = Dotenv.load();
    public static JDA builder;

    public static void main(String[] args) throws LoginException {

        builder = JDABuilder.createDefault(dotenv.get("TOKEN"))
                .addEventListeners(new CommandExecutor()/*, new JoinLeaveListener(), new ReactionListener()*/)
                .setActivity(Activity.playing("Reads books"))
                .build();

        Loader.onInitialize();


        new ListaaKirjat();
    }

}
