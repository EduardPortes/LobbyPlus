package me.p0rtz.lobbyplus.listeners;

import me.p0rtz.lobbyplus.LobbyPlus;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.Team;


public class onChat implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        updatePlayerPrefix(event.getPlayer());
    }


    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        String prefix = getPrefixForPlayer(event.getPlayer());
        event.setFormat(prefix + " %s: %s");
    }

    public static String getPrefixForPlayer(org.bukkit.entity.Player player) {
        if (player.hasPermission("group.dono")){
            return "§0Dono §f";
        } else if (player.hasPermission("group.dev")){
            return "§2Dev §f";
        } else if (player.hasPermission("group.builder")){
            return "§6Builder §f";
        } else if (player.hasPermission("group.default")){
            return "§7Default §f";
        }
        return "§7Default §f";
    }

    public static void updatePlayerPrefix(org.bukkit.entity.Player player) {
        String prefix = getPrefixForPlayer(player);

        Team team = LobbyPlus.scoreboard.getTeam(prefix);
        if (team == null) {
            team = LobbyPlus.scoreboard.registerNewTeam(prefix);
            team.setPrefix(prefix);
        }

        team.addEntry(player.getName()); // Adiciona o jogador à equipe
        player.setScoreboard(LobbyPlus.scoreboard);

        player.setPlayerListName(prefix + player.getName());
    }
}
