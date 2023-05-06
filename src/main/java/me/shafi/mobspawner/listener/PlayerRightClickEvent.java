package me.shafi.mobspawner.listener;

import me.shafi.mobspawner.MobSpawner;
import me.shafi.mobspawner.object.Item;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRightClickEvent implements Listener {
    MobSpawner plugin;

    public PlayerRightClickEvent(MobSpawner plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItem();
        Item item = plugin.getItem();
        if(!itemStack.getItemMeta().getLore().equals(item.getLore())){return;}

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR){

            long lastspawned = plugin.getConfig().getLong("data." + player.getUniqueId());

            long difference = System.currentTimeMillis() - lastspawned;

            int cooldown = plugin.getConfig().getInt("cooldown");

            if(difference < (cooldown * 1000)) {
                player.sendMessage("cant use this item wait for " + (cooldown - (difference/1000)));
                return;
            }

            Location location = player.getLocation();
            location.getWorld().spawnEntity(location , item.getMob());
            plugin.getConfig().set("data." + player.getUniqueId() , System.currentTimeMillis());
            plugin.saveConfig();

        }
        event.setCancelled(true);
    }

}
