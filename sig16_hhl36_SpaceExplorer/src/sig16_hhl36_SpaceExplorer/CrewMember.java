package sig16_hhl36_SpaceExplorer;

/**
 * Implements a crew member class, each crew member will have their own custom name, health
 * type, action limit, hunger rate, hunger level, ability. Methods implemented to allow
 * the player to check status, add health and check if they're sick. 
 * 
 */
public class CrewMember {
	
	private String name;
	private int health;
	private String type;
	public int action;
	private int healthdroprate;
	private int hungerrate;
	private int tirednessrate;
	private int vitality;
	private int hungerLevel;
	private String ability;
	private boolean sick;
	
    /**
     * Creates a Crew Member.
     * @param memberName - Given name of crew member.
     * @param crewType - The type of crew member. For example, technician, superman, hungryboy.
     * @param crewHealthdroprate - The rate at which the health drops.
     * @param crewHungerrate - The rate at which a crew member becomes hungry.
     * @param crewTirednessrate - The rate at which the crew member starts to become tired.
     * @param crewAbility - The specific ability given to a crew member. For example, part seeker and technician.
     */
	public CrewMember(String memberName, String crewType, int crewHealthdroprate, int crewHungerrate, int crewTirednessrate, String crewAbility) {
		name = memberName;
		health = 100;
		type = crewType;
		action = 2;
		vitality = 100;
		hungerLevel = 100;
		healthdroprate = crewHealthdroprate;
		hungerrate = crewHungerrate;
		tirednessrate = crewTirednessrate;
		ability = crewAbility;
		sick = false;
	}
	
    /**
     * Sets name of the crew member to a new user defined name.
     * @param newName - Given name of crew member.
     */
	public void setname(String newName) {
		name = newName;
	}
	
    /**
     * Sets name of the crew member to a new user defined name.
     * @return name - Given name of crew member.
     */
	public String getName() {
		return name;
	}
	
    /**
     * Gets current amount of actions of the crew member.
     * @return action - number of actions left.
     */
	public int getaction() {
		return action;
	}
	
    /**
     * Gets current amount of health of the crew member.
     * @return health - Amount of health remaining.
     */
	public int gethealth() {
		return health;
	}
	
    /**
     * Gets the ability of the crew member.
     * @return ability - ability of the crew member.
     */
	public String getAbility() {
		return ability;
	}
	
    /**
     * Resets amount of actions back to 
     * default value of 2 for the crew member.
     */
	public void resetaction() {
		action = 2;
	}
    /**
     * Subtracts action of the crew member by 1 each time this method is called.
     */
	public void subtractaction() {
		action -= 1;
	}
	
    /**
     * Returns a boolean value if the crew member is sick.
     * @return sick - If crew member is sick, returns true. If crew member
     * is not sick, returns false.
     */
	public boolean issick() {
		return sick;
	}
    /**
     * Sets sick to false for the crew member.
     */
	public void recovery() {
		sick = false;
	}
    /**
     * Sets sick to true for the crew member.
     */
	public void sick() {
		sick = true;
	}
	
    /**
     * Allows the crew member to sleep while increasing vitality by 20 if
     * below 100, otherwise, sets vitality to 100.
     */
	public void sleep() {
		if ((vitality + 20) < 100) {
			vitality += 20;
		} else {
			vitality = 100;
		}
	}
	
    /**
     * Adds a specified amount of health for the crew member if less than 100,
     * otherwise, sets health to 100.
     * @param addedamount - The amount of health to add to the remaining health
     * of the crew member.
     */
	public void addhealth(int addedamount) {
		if (health + addedamount < 100) {
			health += addedamount;
		} else {
			health = 100;
		}
	}
    /**
     * Decreases current health by lost health from the crew member while sick.
     * @param losthealth - Lost health from the crew member being sick.
     */
	public void sicklost(int losthealth) {
		health -= losthealth;
	}
	
    /**
     * Sets health, vitality and hungerlevel
     * @return action - number of actions left.
     */
	public void newday() {
		health *= ((100 - healthdroprate) / 100);
		vitality *= ((100 - tirednessrate) / 100);
		hungerLevel *= ((100 - hungerrate) / 100);
	}
	public void addnutrition(int nutritionamount) {
		if (hungerLevel + nutritionamount < 100) {
			hungerLevel += nutritionamount;
		} else {
			hungerLevel = 100;
		}
	}
	
	public String viewtype() {
		return type;
	}
	public String viewStatus() {
		String status = "Current status for " + name +":\n" +"Type: " + type + "\nHunger: " + hungerLevel +"\nVitality: " + vitality + "\nHealth: " + health +
				"\nAction left:"+ action+"\nSick: " +sick;
		return status;
	}
	
}

