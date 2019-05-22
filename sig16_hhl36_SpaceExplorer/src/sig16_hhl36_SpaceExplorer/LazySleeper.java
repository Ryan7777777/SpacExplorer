package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by CrewMember.
 * Creates crew member of type lazy sleeper. 
 */
public class LazySleeper extends CrewMember{
	private static String memberName = "name";
	private static String crewType = "LazySleeper";
	private static int crewHealthdroprate = 10;
	private static int crewHungerrate = 10;
	private static int crewTirednessrate = 20;
	private static String crewAbility = "ZZZzzzZZZzzz!";
	
	/**
	 * Default constructor for lazy sleeper.
	 */
	public LazySleeper() {
		super(memberName, crewType, crewHealthdroprate, crewHungerrate, crewTirednessrate, crewAbility);
	}
}
