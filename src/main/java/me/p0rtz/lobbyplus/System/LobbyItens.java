package me.p0rtz.lobbyplus.System;

import me.p0rtz.lobbyplus.commands.CommandKit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Set;

public class LobbyItens implements Listener {

    private static final ItemStack specialItem = new ItemStack(Material.DIAMOND, 1);
    private Set<String> jogadoresPermitidos = CommandKit.getJogadoresPermitidos();


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        giveImutableItem(event.getPlayer());
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        ItemStack droppedItem = event.getItemDrop().getItemStack();

        if (droppedItem.isSimilar(specialItem)){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        // VERIFICA SE O JOGADOR É O QUE ESTÁ CLICANDO
        if (event.getWhoClicked() instanceof Player){
            var player = (Player) event.getWhoClicked();
            var clickedItem = event.getCurrentItem();

            //  VERIFICA SE O ITEM É O ITEM ESPECIAL
            if (clickedItem != null && clickedItem.getType() == specialItem.getType() && !jogadoresPermitidos.contains(player.getName())){
                event.setCancelled(true);
            }

        }
    }


    private void giveImutableItem(org.bukkit.entity.Player player){

        player.getInventory().clear();

        ItemMeta meta = specialItem.getItemMeta();

        if (meta != null){
            meta.setDisplayName("Item Especial");
            specialItem.setItemMeta(meta);
        }

        player.getInventory().setItem(1, specialItem);



    }

}
