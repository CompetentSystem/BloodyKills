package competentsystem.plugin.bloodykills.blood.types;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;

import competentsystem.plugin.bloodykills.blood.Blood;
import competentsystem.plugin.bloodykills.gore.Gore;

public class MutantBlood implements Blood {

    @SuppressWarnings("deprecation")
    @Override
    public void executeBloodEffects(LivingEntity damager, LivingEntity damaged) {
	executeBloodParticles(damager, damaged, Material.ENDER_PORTAL.getId());
    }

    @Override
    public void executeGore(LivingEntity damaged) {
	Gore.dropGore(damaged, Material.ENDER_PEARL, (byte) 0);
    }
}
