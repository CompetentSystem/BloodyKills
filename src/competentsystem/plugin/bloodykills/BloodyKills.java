package competentsystem.plugin.bloodykills;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import competentsystem.plugin.bloodykills.blood.BloodMerge;
import competentsystem.plugin.bloodykills.gore.GoreHandler;

public class BloodyKills extends JavaPlugin {

    private static JavaPlugin plugin;
    
    @Override
    public void onEnable() {
	plugin = this;
	if (!(new File(getDataFolder(), "config.yml")).exists()) {
	    saveDefaultConfig();
	}
	
	new BloodMerge();
	new BloodyKillsHandler();
	new GoreHandler();
    }
    
    @Override
    public void onDisable() {
	plugin = null;
    }

    public static JavaPlugin getPlugin() {
	return plugin;
    }

    public static void setPlugin(JavaPlugin plugin) {
	BloodyKills.plugin = plugin;
    }
}
