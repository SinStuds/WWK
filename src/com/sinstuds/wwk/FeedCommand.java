package com.sinstuds.wwk;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    private WWK plugin = WWK.getPlugin(WWK.class);

    public FeedCommand(){
        plugin.getCommand("feed").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("wwk.cmd.feed")){
            if(sender instanceof Player) {
                Player player = (Player) sender;
                player.setFoodLevel(20);
                player.setSaturation(20);
                player.sendMessage("Your hunger was restored");
                return true;
            }
        }
        return false;
    }
}