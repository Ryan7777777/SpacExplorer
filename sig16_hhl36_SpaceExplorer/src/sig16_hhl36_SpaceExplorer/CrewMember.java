package sig16_hhl36_SpaceExplorer;

public class CrewMember {
	
	private String name;
	private int health;
	private String type;
	private int action;
	private int healthdroprate;
	private int hungerrate;
	private int tirednessrate;
	private int vitality;
	private int hungrylevel;
	private String ability;
	private boolean sick;
	
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
	public void setname(String newName) {
		name = newName;
	}
	public int getaction() {
		return action;
	}
	public int gethealth() {
		return health;
	}
	public void resetaction() {
		action = 2;
	}
	public void subtractaction() {
		action = action -1;
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
			hungrylevel -= nutritionamount;
		} else {
			hungrylevel = 100;
		}
	}
	
	public String viewtype() {
		return type;
	}
	public String viewStatus() {
		String status = "Current status for " + name +":\n" + "Hunger: " + hungrylevel +"\nVitality: " + vitality + "\nHealth: " + health;
		return status;
	}
	
}

