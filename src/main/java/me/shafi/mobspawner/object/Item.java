package me.shafi.mobspawner.object;

import lombok.Getter;
import me.shafi.mobspawner.MobSpawner;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Item {

    ItemStack item;
    List<String> lore = new ArrayList<>();
    EntityType mob;

    public Item(MobSpawner plugin){
        item = new ItemStack(Material.DRAGON_EGG);
        lore.add("Right Click to spawn the mob");
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.SILK_TOUCH , 1, true);
        meta.setLore(lore);
        item.setItemMeta(meta);
        mob = EntityType.valueOf(plugin.getConfig().getString("mob"));
    }

}
