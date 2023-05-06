package me.shafi.mobspawner;

import lombok.Getter;
import me.shafi.mobspawner.commands.SpawnItem;
import me.shafi.mobspawner.listener.PlayerRightClickEvent;
import me.shafi.mobspawner.object.Item;
import org.bukkit.plugin.java.JavaPlugin;


@Getter
public final class MobSpawner extends JavaPlugin {


    Item item;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getLogger().info("Plugin has enabled");
        this.getServer().getPluginCommand("item").setExecutor(new SpawnItem(this));
        this.getServer().getPluginManager().registerEvents(new PlayerRightClickEvent(this) , this);
        item = new Item(this);
    }

    @Override
    public void onDisable() {

    }

}
