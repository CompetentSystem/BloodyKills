package competentsystem.plugin.bloodykills.blood.types;

import org.bukkit.entity.LivingEntity;

import competentsystem.plugin.bloodykills.blood.Blood;

public class NormalBlood implements Blood {

    @Override
    public void executeBloodEffects(LivingEntity damager, LivingEntity damaged) {
	executeBloodParticles(damager, damaged, 115);
    }

    @Override
    public void executeGore(LivingEntity damaged) {
	// no gore
    }
}
