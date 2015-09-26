package competentsystem.plugin.bloodykills.configuration;

public class UnknownBloodTypeException extends Exception {

    private static final long serialVersionUID = 1L;

    public UnknownBloodTypeException(String bloodName) {
	super("Unknown blood type for: " + bloodName + "!");
    }
}
