package com.sinstuds.wwk;
import org.bukkit.plugin.java.JavaPlugin;

public class WWK extends JavaPlugin {
    @Override
    public void onEnable(){
        System.out.println("dumalamuelscawnasdadadandadandadiafrsgiusu");
        new HealCommand();
        new FeedCommand();
        new FBL();
        new FBLTrigger();
        new PBlade();
        new PBladeTrigger();
        new PBow();
        new PBowTrigger();

    }
    @Override
    public void onDisable(){

    }
}

