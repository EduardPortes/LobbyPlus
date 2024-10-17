package me.p0rtz.lobbyplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashSet;
import java.util.Set;

public class CommandKit implements CommandExecutor, Listener {

    public static Set<String> jogadoresPermitidos = new HashSet<>();

    public static Set<String> getJogadoresPermitidos() {
        return jogadoresPermitidos;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        var player = event.getPlayer();
        if (jogadoresPermitidos.contains(player.getName())) {
            jogadoresPermitidos.remove(player.getName());
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("perm") && sender instanceof Player && ((Player) sender).getPlayer().hasPermission("lobbyplus.move") ) {
            var player = ((Player) sender).getPlayer();

            // Adiciona ou remove o jogador da lista de permitidos
            if (jogadoresPermitidos.contains(player.getName())) {
                jogadoresPermitidos.remove(player.getName());
                player.sendMessage("Você não pode mais mover o item especial.");
            } else {
                jogadoresPermitidos.add(player.getName());
                player.sendMessage("Você agora pode mover o item especial.");
            }
            return true;
        }
        return false;
    }
}
