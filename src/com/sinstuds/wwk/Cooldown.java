package com.sinstuds.wwk;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.UUID;

public class Cooldown {

    public Cooldown(int seconds) {
        this.seconds = seconds;
    }

    private int seconds = 0;

    private HashMap<UUID, Long> hashmap = new HashMap();

    public void putInCooldown(Player player) {
        hashmap.put(player.getUniqueId(), System.currentTimeMillis() + (seconds * 1000L));
    }

    public boolean isOnCooldown(Player player) {
        UUID uuid = player.getUniqueId();
        return (hashmap.get(uuid) != null && hashmap.get(uuid) > System.currentTimeMillis());
    }

    public int getCooldownSeconds(Player player) {
        UUID uuid = player.getUniqueId();
        return (int)  ((hashmap.get(uuid) - System.currentTimeMillis()) / 1000L);
    }
}
