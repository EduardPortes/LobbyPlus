package me.p0rtz.lobbyplus;

import me.p0rtz.lobbyplus.listeners.onChat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import static org.bukkit.Bukkit.getPluginManager;

public class LobbyPlus extends JavaPlugin implements Listener {

    private ScoreboardManager manager;
    public static Scoreboard scoreboard;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String NAME = "["+ ANSI_PURPLE + "PluginDefault" + ANSI_RESET + "]";

    @Override
    public void onEnable() {
        System.out.println(NAME + ANSI_GREEN + "     ---------------------------------" + ANSI_RESET);
        System.out.println(NAME +"     This plugin is now running");
        System.out.println(NAME + ANSI_YELLOW +"     Version: " + ANSI_RESET +" 1.1");
        System.out.println(NAME + ANSI_GREEN + "     ---------------------------------" + ANSI_RESET);

        getPluginManager().registerEvents(new onChat(), this);
        manager = Bukkit.getScoreboardManager();
        scoreboard = manager.getMainScoreboard();
    }

    @Override
    public void onDisable() {

        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        System.out.println("This plugin has stopped running");
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");

    }



}