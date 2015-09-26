package competentsystem.plugin.bloodykills;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import competentsystem.plugin.bloodykills.configuration.BloodSelection;

public class BloodyKillsHandler implements Listener {

    private BloodSelection bloodSelection;

    public BloodyKillsHandler() {
	Bukkit.getServer().getPluginManager().registerEvents(this, BloodyKills.getPlugin());
	bloodSelection = new BloodSelection();
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
	Entity damager = event.getDamager(), damaged = event.getEntity();
	if (damager instanceof LivingEntity) {
	    if (damaged instanceof Player) {
		bloodSelection.getSelectedPlayersBloodType().executeBloodEffects((LivingEntity) damager,
			(LivingEntity) damaged);
	    } else {
		bloodSelection.getSelectedMobsBloodType().executeBloodEffects((LivingEntity) damager,
			(LivingEntity) damaged);
	    }
	}
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
	Entity damaged = event.getEntity();
	if (damaged instanceof Player) {
	    bloodSelection.getSelectedPlayersBloodType().executeGore((LivingEntity) damaged);
	} else {
	    bloodSelection.getSelectedMobsBloodType().executeGore((LivingEntity) damaged);
	}
    }
}
