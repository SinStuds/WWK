package com.sinstuds.wwk;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class PBlade implements CommandExecutor {

    private WWK plugin = WWK.getPlugin(WWK.class);
    public static String ITEM_NAME = Util.format("&4Halver");

    public PBlade(){
        plugin.getCommand("pblade").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("wwk.cmd.pblade")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                ItemStack pBlade = new ItemStack(Material.WOODEN_SWORD);
                ItemMeta pbladeMeta = pBlade.getItemMeta();
                pbladeMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("generic.attackSpeed", 30, AttributeModifier.Operation.ADD_NUMBER));
                pbladeMeta.setUnbreakable(true);
                pbladeMeta.setDisplayName(ITEM_NAME);
                pBlade.setItemMeta(pbladeMeta);
                player.getInventory().addItem(pBlade);
                sender.sendMessage(Util.format("&7..."));



                return true;
            }
        }
        return false;
    }
}
