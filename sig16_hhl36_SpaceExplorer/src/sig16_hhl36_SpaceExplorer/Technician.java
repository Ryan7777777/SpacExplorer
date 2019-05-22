package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by CrewMember.
 * Creates crew member of type technician. 
 */
public class Technician extends CrewMember{
	private static String memberName = "name";
	private static String crewType = "Technician";
	private static int crewHealthdroprate = 10;
	private static int crewHungerrate = 10;
	private static int crewTirednessrate = 8;
	private static String crewAbility = "Good at repair";
	
	/**
	 * Default constructor for technician.
	 */	
	public Technician() {
		super(memberName, crewType, crewHealthdroprate, crewHungerrate, crewTirednessrate, crewAbility);
	}
}
