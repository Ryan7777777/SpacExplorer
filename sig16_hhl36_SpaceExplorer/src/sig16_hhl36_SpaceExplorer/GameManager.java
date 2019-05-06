package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;

public class GameManager {
	
	private String shipname;
	private String crewname;
	private double money = 100;
	private ArrayList<CrewMember> crew_member = new ArrayList<CrewMember>();
	//private ArrayList<Food_Item> crew_food = new ArrayList<Food_Item>();
	//private ArrayList<MedicalItem> crew_medical = new ArrayList<MedicalItem>();
	
	public void setupShipname(String name) {
		shipname = name;
	}
	
	public void setupCrewname(String name) {
		crewname = name;
	}
	
	public String viewShipname() {
		return shipname;
	}
	
	public String viewCrewname() {
		return crewname;
	}
	
	public void addCrew(CrewMember crew) {
		crew_member.add(crew);
	}
	
	public void printAllPlanets() {
		for (CrewMember crewmember: crew_member) {
			System.out.println(crewmember.viewtype());
		}
	}
	
	public static void main(String arg[]) {
		CrewMember hungryboy = new HungryBoy();
		GameManager crew = new GameManager();
		crew.addCrew(hungryboy);
		crew.printAllPlanets();
	}
	
}
