package com.sinstuds.wwk;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FBL implements CommandExecutor {

    private WWK plugin = WWK.getPlugin(WWK.class);
    public static String ITEM_NAME = Util.format("&4FBlauncher");

    public FBL(){
        plugin.getCommand("FBL").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("wwk.cmd.fbl")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack ballLauncher = new ItemStack(Material.GOLDEN_SHOVEL);
                ItemMeta ballMeta = ballLauncher.getItemMeta();
                ballMeta.setDisplayName(ITEM_NAME);
                ballLauncher.setItemMeta(ballMeta);
                player.getInventory().addItem(ballLauncher);
                sender.sendMessage(Util.format("&7You can now launch balls"));




                return true;
            }
        }
        return false;
    }
}
