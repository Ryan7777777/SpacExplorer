package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by CrewMember.
 * Creates crew member of type superman. 
 */
public class Superman extends CrewMember{
	private static String memberName = "name";
	private static String crewType = "Superman";
	private static int crewHealthdroprate = 4;
	private static int crewHungerrate = 4;
	private static int crewTirednessrate = 4;
	private static String crewAbility = "Everything is easy for him";
	
	/**
	 * Default constructor for superman.
	 */	
	public Superman() {
		super(memberName, crewType, crewHealthdroprate, crewHungerrate, crewTirednessrate, crewAbility);
	}
}
