package me.p0rtz.lobbyplus.System;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class MessageTask extends BukkitRunnable  {

    private final String msg;

    public MessageTask(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        Bukkit.broadcastMessage(msg);
    }


}
