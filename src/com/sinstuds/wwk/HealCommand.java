package com.sinstuds.wwk;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    private WWK plugin = WWK.getPlugin(WWK.class);

    public HealCommand(){
        plugin.getCommand("heal").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("wwk.cmd.heal")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(20);
                player.sendMessage("You have been healed");
                return true;
            }
        }
        return false;
    }
}
