package sig16_hhl36_SpaceExplorer;

public class CrewMenber {
	private String name;
	private int health;
	private String type;
	private int action;
	private int healthrate;
	private int hungerrate;
	private int tirednesrate;
	private String ability;
	public void CrewMenber(String crew_name, String crew_type, int crew_healthrate, int crew_hungerrate
			,int crew_tirednesrate, String crew_ability) {
		name = crew_name;
		health = 100;
		type = crew_type;
		action = 2;
		healthrate = crew_healthrate;
		hungerrate = crew_hungerrate;
		tirednesrate = crew_tirednesrate;
		ability = crew_ability;
	}
	}
