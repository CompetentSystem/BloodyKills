package competentsystem.plugin.bloodykills.gore;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Gore {

    public static void dropGore(LivingEntity damaged, Material material, byte data) {
	Item item = null;
	for (int i = 0; i < 10; i++) {
	    item = damaged.getWorld().dropItem(damaged.getEyeLocation(), new ItemStack(material, 1, data));
	    item.setVelocity(
		    new Vector((Math.random() - 0.5D) * 0.5D, Math.random() * 0.5D, (Math.random() - 0.5D) * 0.5D));
	    item.setPickupDelay(Integer.MAX_VALUE);
	    if (!GoreHandler.getGoreItems().contains(item)) {
		GoreHandler.getGoreItems().add(item);
	    }
	}
    }
}
