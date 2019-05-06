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
		hungrylevel = 0;
		healthdroprate = crewHealthdroprate;
		hungerrate = crewHungerrate;
		tirednessrate = crewTirednessrate;
		ability = crewAbility;
		sick = false;
	}
	
	public void sick() {
		sick = true;
		healthdroprate = 20;
	}
	
	public void recovery() {
		sick = false;
		healthdroprate = 10;
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
	
	public void eat(int nutritionamount) {
		if (hungrylevel - nutritionamount > 0) {
			hungrylevel -= nutritionamount;
		} else {
			hungrylevel = 0;
		}
	}
	
	public String viewtype() {
		System.out.println(type);
		return type;
	}
}

