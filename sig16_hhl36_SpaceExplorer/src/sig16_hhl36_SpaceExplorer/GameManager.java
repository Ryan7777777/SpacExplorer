package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;

public class GameManager {
	private String shipname;
	private String crewname;
	private Double  money = (double) 100;
	private ArrayList<CrewMenber> crew_menber = new ArrayList<CrewMenber>();
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
	public void addCrew(CrewMenber crew) {
		crew_menber.add((CrewMenber)crew);
	}
	public void printAllPlanets() {
		for (CrewMenber crewmenber: crew_menber) {
			System.out.println(crewmenber.viewtype());
		}
	}
	public static void main(String arg[]) {
		CrewMenber hungyboy = new HungyBoy();
		GameManager crew = new GameManager();
		crew.addCrew(hungyboy);
		crew.printAllPlanets();
		
	}
	

}
