package competentsystem.plugin.bloodykills.configuration;

import competentsystem.plugin.bloodykills.BloodyKills;
import competentsystem.plugin.bloodykills.blood.Blood;
import competentsystem.plugin.bloodykills.blood.types.CartoonyBlood;
import competentsystem.plugin.bloodykills.blood.types.MutantBlood;
import competentsystem.plugin.bloodykills.blood.types.NormalBlood;

public class BloodSelection {

    public synchronized Blood getSelectedPlayersBloodType() {
	try {
	    return getSelectedBloodType("players-blood-type");
	} catch (UnknownBloodTypeException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public synchronized Blood getSelectedMobsBloodType() {
	try {
	    return getSelectedBloodType("mobs-blood-type");
	} catch (UnknownBloodTypeException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    private Blood getSelectedBloodType(String configurationLocation) throws UnknownBloodTypeException {
	String bloodName = BloodyKills.getPlugin().getConfig().getString(configurationLocation);
	switch (bloodName) {
	case "cartoon":
	    return new CartoonyBlood();
	case "normal":
	    return new NormalBlood();
	case "mutant":
	    return new MutantBlood();
	default:
	    throw new UnknownBloodTypeException(bloodName);
	}
    }
}
