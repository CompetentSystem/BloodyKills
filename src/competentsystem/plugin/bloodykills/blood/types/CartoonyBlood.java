package competentsystem.plugin.bloodykills.blood.types;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;

import competentsystem.plugin.bloodykills.blood.Blood;
import competentsystem.plugin.bloodykills.gore.Gore;

public class CartoonyBlood implements Blood {

    @Override
    public void executeBloodEffects(LivingEntity damager, LivingEntity damaged) {
	executeBloodParticles(damager, damaged, 115);
    }

    @Override
    public void executeGore(LivingEntity damaged) {
	Gore.dropGore(damaged, Material.INK_SACK, (byte) 1);
    }
}
