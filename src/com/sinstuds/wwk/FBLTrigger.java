package com.sinstuds.wwk;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class FBLTrigger implements Listener {
    private WWK plugin = WWK.getPlugin(WWK.class);

    public FBLTrigger(){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if(item.getItemMeta().getDisplayName().equals(FBL.ITEM_NAME)) {
            Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(2)).
                    toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
            Fireball fireball = player.getWorld().spawn(loc, Fireball.class);
            fireball.setShooter(player);
        }
    }
}
