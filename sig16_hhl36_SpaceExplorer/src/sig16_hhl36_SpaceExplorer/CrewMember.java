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
	private int hungrylevel;
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
		hungrylevel = 100;
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
     * Sets name of the crew member to a new user defined name.
     * @return name - Given name of crew member.
     */
	public int getaction() {
		return action;
	}
	public int gethealth() {
		return health;
	}
	public String getAbility() {
		return ability;
	}
	public void resetaction() {
		action = 2;
	}
	public void subtractaction() {
		action -= 1;
	}
	public boolean issick() {
		return sick;
	}
	public void recovery() {
		sick = false;
	}
	public void sick() {
		sick = true;
	}
	public void sleep() {
		if ((vitality + 20) < 100) {
			vitality += 20;
		} else {
			vitality = 100;
		}
	}
	
	public void addhealth(int addedamount) {
		if (health + addedamount < 100) {
			health += addedamount;
		} else {
			health = 100;
		}
	}
	public void sicklost(int losthealth) {
		health -= losthealth;
	}
	public void newday() {
		health = health *(100-healthdroprate)/100;
		vitality = vitality *(100-tirednessrate)/100;
		hungrylevel = hungrylevel*(100-hungerrate)/100;
	}
	public void addnutrition(int nutritionamount) {
		if (hungrylevel + nutritionamount < 100) {
			hungrylevel += nutritionamount;
		} else {
			hungrylevel = 100;
		}
	}
	
	public String viewtype() {
		return type;
	}
	public String viewStatus() {
		String status = "Current status for " + name +":\n" +"Type: " + type + "\nHunger: " + hungrylevel +"\nVitality: " + vitality + "\nHealth: " + health +
				"\nAction left:"+ action+"\nSick: " +sick;
		return status;
	}
	
}

