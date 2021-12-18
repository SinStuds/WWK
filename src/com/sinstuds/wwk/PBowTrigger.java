package com.sinstuds.wwk;


import net.minecraft.world.item.ItemArrow;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PBowTrigger implements Listener {
    private WWK plugin = WWK.getPlugin(WWK.class);
    private Cooldown cd = new Cooldown(1);

    public PBowTrigger() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!cd.isOnCooldown(player)) {
            if (item.getItemMeta().getDisplayName().equals(PBow.ITEM_NAME)) {
                Location loc = player.getEyeLocation().toVector().add(player.getLocation().getDirection().multiply(0.7)).
                        toLocation(player.getWorld(), player.getLocation().getYaw(), player.getLocation().getPitch());
                Arrow arrow = (Arrow) loc.getWorld().spawnEntity(loc, EntityType.ARROW);
                arrow.setVelocity(loc.getDirection().normalize().multiply(7));
                cd.putInCooldown(player);
            }
            else{
                player.sendMessage(Util.format("&7On Cooldown!"));
                // bobby jones
            }
        }
    }
}