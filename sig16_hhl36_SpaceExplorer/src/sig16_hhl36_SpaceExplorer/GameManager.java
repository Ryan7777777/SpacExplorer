package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;

public class GameManager {
	
	private String shipName;
	private String crewName;
	private int crewSize;
	private double crewMoney;
	private int shieldhealth;
	private ArrayList<CrewMember> crew_members = new ArrayList<CrewMember>();
	private ArrayList<Food_Item> crew_food = new ArrayList<Food_Item>();
	private ArrayList<Medical_Item> crew_medical = new ArrayList<Medical_Item>();
	private ArrayList<Food_Item> food_sell = new ArrayList<Food_Item>();
	private ArrayList<Medical_Item> medical_sell = new ArrayList<Medical_Item>();
	
	public GameManager(String teamName, String vehicleName) {
		shipName = vehicleName;
		crewName = teamName;
		crewSize = 0;
		crewMoney = 100.0;
		shieldhealth = 100;
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
	public void setFoodstore() {
		Food_Item peach = new Peaches();
		Food_Item butter_chicken = new ButterChicken();
		Food_Item banana = new Banana();
		Food_Item hamsandwiches = new HamSandwiches();
		Food_Item strawberry = new Strawberries();
		Food_Item sapghettibologonese = new SpaghettiBolognese();
		food_sell.add(peach);
		food_sell.add(butter_chicken);
		food_sell.add(hamsandwiches);
		food_sell.add(strawberry);
		food_sell.add(sapghettibologonese);
		food_sell.add(banana);
	}
	public void setMedicalstore() {
		Medical_Item largenedoack = new LargeMedPack();
		Medical_Item plaguecure = new PlagueCure();
		Medical_Item smallmedpack = new SmallMedPack();
		medical_sell.add(largenedoack);
		medical_sell.add(plaguecure);
		medical_sell.add(smallmedpack);
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
	public int getShieldhealth() {
		return shieldhealth;
	}
	
	public void addCrew(CrewMember crew) {
		int count = crew_members.size();
		crew_members.add(crew);
		setCrewSize(count + 1);
	}
	
	public void printAllCrewMembers() {
		for (CrewMember crewmember: crew_members) {
			System.out.println(crewmember.viewtype());
		}
	}
	public void printStatus() {
		for (CrewMember crewmember: crew_members) {
			System.out.println(crewmember.viewStatus());
		}
	}
	
	public static void main(String arg[]) {
		CrewMember hungryboy = new HungryBoy();
		CrewMember hungry = new HungryBoy();
		hungryboy.setname("Name1");
		hungry.setname("Name2");
		GameManager crew = new GameManager("The Space Invaders", "Normandy");
		crew.addCrew(hungryboy);
		crew.addCrew(hungry);
		crew.printAllCrewMembers();
		crew.printStatus();
		System.out.println(crew.getCrewSize());
		System.out.println(crew.getShipname());
		crew.setMedicalstore();
		crew.viewMedicalStore();
		
	}
	
}
