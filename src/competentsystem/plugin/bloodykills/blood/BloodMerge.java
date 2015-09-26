package competentsystem.plugin.bloodykills.blood;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftItem;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import competentsystem.plugin.bloodykills.BloodyKills;
import net.minecraft.server.v1_8_R3.EntityItem;

public class BloodMerge implements Listener {

    private static HashMap<Item, String> items;

    public BloodMerge() {
	Bukkit.getServer().getPluginManager().registerEvents(this, BloodyKills.getPlugin());
	items = new HashMap<>();
    }
    
    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {
	Item item = e.getEntity();
	ItemStack itemStack = item.getItemStack();
	EntityItem nmsItem = (EntityItem) ((CraftItem) item).getHandle();

	items.put(item, itemStack.hasItemMeta() ? itemStack.getItemMeta().getDisplayName() : item.getCustomName());

	nmsItem.getItemStack().c(String.valueOf(nmsItem.getUniqueID()));
    }

    @EventHandler
    public void onPlayerPickup(PlayerPickupItemEvent e) {
	pickupItem(e.getItem());
    }

    @EventHandler
    public void onHopperPickup(InventoryPickupItemEvent e) {
	pickupItem(e.getItem());
    }

    private void pickupItem(Item item) {
	Item expired = null;
	if (items.containsKey(item)) {
	    ItemStack itemStack = item.getItemStack();
	    ItemMeta itemMeta = itemStack.hasItemMeta() ? itemStack.getItemMeta() : null;
	    if (itemMeta != null) {
		itemMeta.setDisplayName(items.get(item));
		itemStack.setItemMeta(itemMeta);
		item.setItemStack(itemStack);
	    }
	    expired = item;
	}
	if (expired != null) {
	    items.remove(expired);
	}
    }
}
