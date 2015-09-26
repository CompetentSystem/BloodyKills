package competentsystem.plugin.bloodykills.blood;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public interface Blood {

    default void executeBloodParticles(LivingEntity damager, LivingEntity damaged, int materialId) {
	damaged.getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND, materialId);
	if (damager instanceof Player) {
	    ((Player) damager).playSound(damager.getLocation(), Sound.HURT_FLESH, 1, 1);
	}
    }
    
    void executeBloodEffects(LivingEntity damager, LivingEntity damaged);
    
    void executeGore(LivingEntity damaged);
}
