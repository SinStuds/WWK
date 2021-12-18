package com.sinstuds.wwk;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PBow implements CommandExecutor {

    private WWK plugin = WWK.getPlugin(WWK.class);
    public static String ITEM_NAME = Util.format("&4Mermitator");

    public PBow(){
        plugin.getCommand("pbow").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("wwk.cmd.pbow")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack ballLauncher = new ItemStack(Material.BOW);
                ItemMeta bowMeta = ballLauncher.getItemMeta();
                bowMeta.setDisplayName(ITEM_NAME);
                ballLauncher.setItemMeta(bowMeta);
                player.getInventory().addItem(ballLauncher);
                sender.sendMessage(Util.format("&Mermitator"));
                return true;
            }
        }
        return false;
    }
}
