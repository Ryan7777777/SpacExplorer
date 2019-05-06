package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;

public class GameManager {
	
	private String shipName;
	private String crewName;
	private int crewSize;
	private double crewMoney;
	private ArrayList<CrewMember> crew_members = new ArrayList<CrewMember>();
	//private ArrayList<Food_Item> crew_food = new ArrayList<Food_Item>();
	//private ArrayList<MedicalItem> crew_medical = new ArrayList<MedicalItem>();
	
	public GameManager(String teamName, String vehicleName) {
		shipName = vehicleName;
		crewName = teamName;
		crewSize = 0;
		crewMoney = 100.0;
	}
	
	public void setMoney(int money) {
		crewMoney = money;
	}
	
	public double getMoney() {
		return crewMoney;
	}
	
	public void setShipname(String name) {
		shipName = name;
	}
	
	public void setCrewname(String name) {
		crewName = name;
	}
	
	public String getShipname() {
		return shipName;
	}
	
	public String getCrewname() {
		return crewName;
	}
	
	public int getCrewSize() {
		return crewSize;
	}
	
	public void setCrewSize(int size) {
		crewSize = size;
	}
	public void addCrew(CrewMember crew) {
		if (getCrewSize() < 2) {
			throw new IllegalStateException("Please add more crew members!");
		}
		if (getCrewSize() > 4) {
			throw new IllegalStateException("Cannot have more than 4 crew members!");
		}
		else {
			crew_members.add(crew);
			setCrewSize(crew_members.size() + 1);
		}
	}
	
	public void printAllCrewMembers() {
		for (CrewMember crewmember: crew_members) {
			System.out.println(crewmember.viewtype());
		}
	}
	
	public static void main(String arg[]) {
		CrewMember hungryboy = new HungryBoy();
		GameManager crew = new GameManager("The Space Invaders", "Normandy");
		crew.addCrew(hungryboy);
		crew.printAllCrewMembers();
	}
	
}
