package me.shafi.mobspawner.commands;

import me.shafi.mobspawner.MobSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnItem implements CommandExecutor {

    MobSpawner plugin;

    public SpawnItem(MobSpawner plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {
        if(sender instanceof Player p){
            p.getInventory().addItem(plugin.getItem().getItem());
        }
        return false;
    }
}
