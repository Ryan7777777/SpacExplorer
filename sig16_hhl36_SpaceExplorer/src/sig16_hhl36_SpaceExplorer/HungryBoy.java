package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by CrewMember.
 * Creates crew member of type hungry boy. 
 */
public class HungryBoy extends CrewMember {
	private static String memberName = "name";
	private static String crewType = "HungryBoy";
	private static int crewHealthdroprate = 10;
	private static int crewHungerrate = 25;
	private static int crewTirednessrate = 8;
	private static String crewAbility = "Food is life";
	
	/**
	 * Default constructor for hungry boy.
	 */
	public HungryBoy() {
		super(memberName, crewType, crewHealthdroprate, crewHungerrate, crewTirednessrate, crewAbility);
	}
}
