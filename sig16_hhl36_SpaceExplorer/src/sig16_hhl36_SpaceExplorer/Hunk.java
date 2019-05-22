package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by CrewMember.
 * Creates crew member of type hunk. 
 */
public class Hunk extends CrewMember{
	private static String memberName = "name";
	private static String crewType = "Hunk";
	private static int crewHealthdroprate = 5;
	private static int crewHungerrate = 15;
	private static int crewTirednessrate = 8;
	private static String crewAbility = "Big and health";
	
	/**
	 * Default constructor for hunk.
	 */
	public Hunk() {
		super(memberName, crewType, crewHealthdroprate, crewHungerrate, crewTirednessrate, crewAbility);
	}
}
