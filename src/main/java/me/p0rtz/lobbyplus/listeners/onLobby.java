package me.p0rtz.lobbyplus.listeners;

import me.p0rtz.lobbyplus.commands.CommandKit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Set;

public class onLobby implements Listener {

    private Set<String> jogadoresPermitidos = CommandKit.getJogadoresPermitidos();

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        var player = event.getPlayer();
        if (jogadoresPermitidos.contains(player.getName())) {
            jogadoresPermitidos.remove(player.getName());
        }
    }

    @EventHandler
    public void FoodLevel(FoodLevelChangeEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void HealthLevel(EntityDamageEvent event){
        if (event.getEntity() instanceof Player){
            event.setCancelled(true);
        }
    }

}
