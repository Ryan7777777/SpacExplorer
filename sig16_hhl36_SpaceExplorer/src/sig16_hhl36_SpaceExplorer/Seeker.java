package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by CrewMember.
 * Creates crew member of type seeker. 
 */
public class Seeker extends CrewMember{
	private static String memberName = "name";
	private static String crewType = "Seeker";
	private static int crewHealthdroprate = 10;
	private static int crewHungerrate = 10;
	private static int crewTirednessrate = 8;
	private static String crewAbility = "Inch-by-inch search";
	
	/**
	 * Default constructor for seeker.
	 */
	public Seeker() {
		super(memberName, crewType, crewHealthdroprate, crewHungerrate,crewTirednessrate, crewAbility);
	}
}
