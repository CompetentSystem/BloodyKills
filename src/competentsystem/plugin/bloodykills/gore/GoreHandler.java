package competentsystem.plugin.bloodykills.gore;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

import competentsystem.plugin.bloodykills.BloodyKills;

public class GoreHandler {

    private static final List<Item> goreItems;
    
    static {
	goreItems = new ArrayList<>();
    }
    
    public GoreHandler() {
	new BukkitRunnable() {
	    @Override
	    public void run() {
		for (int i = 0; i < goreItems.size(); i++) {
		    Item item = goreItems.get(i);
		    if (item != null && item.isValid() && item.getTicksLived() > 25) {
			item.remove();
			goreItems.remove(i);
		    }
		}
	    }
	}.runTaskTimer(BloodyKills.getPlugin(), 1, 1);
    }

    public static List<Item> getGoreItems() {
	return goreItems;
    }
}
