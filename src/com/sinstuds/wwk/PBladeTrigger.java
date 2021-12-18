package com.sinstuds.wwk;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemFactory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class PBladeTrigger implements Listener {
    private WWK plugin = WWK.getPlugin(WWK.class);

    public PBladeTrigger(){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        int seconds = 2;
        int amplifier = 1;
        if(damager instanceof Player){
            Player player = (Player) damager;
            if(player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(PBlade.ITEM_NAME)){
                if (entity instanceof LivingEntity && damager instanceof LivingEntity) {
                    LivingEntity target = (LivingEntity) entity;
                    target.setMaximumNoDamageTicks(2);
                }
            }
        }
    }
}