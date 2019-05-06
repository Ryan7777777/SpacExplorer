package sig16_hhl36_SpaceExplorer;

public class CrewMember {
	
	private String name;
	private int health;
	private String type;
	private int action;
	private int healthdroprate;
	private int hungerrate;
	private int tirednesrate;
	private int vitality;
	private int hungeylevel;
	private String ability;
	private boolean sick = false;
	
	public CrewMember(String crew_name, String crew_type, int crew_healthdroprate, int crew_hungerrate, 
			int crew_tirednesrate, String crew_ability) {
		name = crew_name;
		health = 100;
		type = crew_type;
		action = 2;
		vitality = 100;
		hungeylevel = 0;
		healthdroprate = crew_healthdroprate;
		hungerrate = crew_hungerrate;
		tirednesrate = crew_tirednesrate;
		ability = crew_ability;
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
		if((vitality + 20) < 100) {
			vitality += 20;
		} else{
			vitality = 100;
		}
	}
	public void addhealth(int addedamount) {
		if(health + addedamount < 100) {
			health += addedamount;
		}else {
			health = 100;
		}
	}
	public void eat(int nutritionamount) {
		if(hungeylevel - nutritionamount > 0) {
			hungeylevel -= nutritionamount;
		} else {
			hungeylevel = 0;
		}
	}
	public String viewtype() {
		System.out.println(type);
		return type;
	}
	}

