package com.adex.kirjabot.listeners;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JoinLeaveListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        Objects.requireNonNull(event.getGuild().getTextChannelById(796743984050864129L)).sendMessage(
                event.getUser().getName() + " joined!").queue();
    }

    @Override
    public void onGuildMemberLeave(@NotNull GuildMemberLeaveEvent event) {
        Objects.requireNonNull(event.getGuild().getTextChannelById(796743984050864129L)).sendMessage(
                event.getUser().getName() + " left!").queue();
    }

}
