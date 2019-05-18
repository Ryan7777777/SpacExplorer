package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;
import java.util.Random;
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
	private int day = 8;
	private int pieces;
	Random rand = new Random();
	public GameManager(String teamName, String vehicleName) {
		shipName = vehicleName;
		crewName = teamName;
		crewSize = 0;
		crewMoney = 100.0;
		shieldhealth = 0;
	}
	
	public void setMoney(int money) {
		crewMoney = money;
	}
	
	public void setShipname(String name) {
		shipName = name;
	}
	public void calculatePieces() {
		double index = day*2/3;
		pieces = (int) Math.floor(index);
	}
	public void setCrewname(String name) {
		crewName = name;
	}
	public void newday() {
		int index = -1;
		int remove = -1;
		for (CrewMember crew: crew_members) {
			index += 1;
			crew.resetaction();
			if(crew.issick() == true) {
				crew.sicklost(10);
			}
			crew.newday();
			if(crew.gethealth() <=0) {
				remove = index;
			}
		}
		if(remove >-1) {
			crew_members.remove(index);
		}
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
	public void viewStore() {
		for (Medical_Item item: medical_sell) {
			System.out.println(item.getMedName());
			System.out.println(item.getPrice());
			System.out.println(item.getHealthAdd());
		}
		for(Food_Item item: food_sell) {
			System.out.println(item.getFoodName());
			System.out.println(item.getFoodNutrition());
			System.out.println(item.getFoodNutrition());
		}
	}
	public String getFood() {
		String food ="";
		for(Food_Item myfood: crew_food) {
			food += "\nFood name:" + myfood.getFoodName();
			food += "\nNutrition :" + myfood.getFoodNutrition();
			food += "\nQuantity :" + myfood.getQuantity();
	}
		return food;
	}
	public String getMedical() {
		String med ="";
		for(Medical_Item mymed: crew_medical) {
			med += "Food name:" + mymed.getMedName();
			med += "\nNutrition :" + mymed.getHealthAdd();
			med += "\nQuantity :" + mymed.getQuantity();
	}
		return med;
	}
	public void foodPurchase(Food_Item object) {
		crewMoney = crewMoney - object.getPrice();
		if(crew_food.contains(object)) {
			for(Food_Item myfood: crew_food) {
				if(myfood.getFoodName() == object.getFoodName()) {
					myfood.addQuantity();
				}
			}
		} else {
			object.addQuantity();
			crew_food.add(object);
		}
	}
	public void medPurchase(Medical_Item object) {
		crewMoney = crewMoney - object.getPrice();
			if(crew_medical.contains(object)) {
				for(Medical_Item mymed: crew_medical) {
					if(mymed.getMedName() == object.getMedName()) {
						mymed.addQuantity();
					}
				}
			} else {
				object.addQuantity();
				crew_medical.add(object);
			}
		}
	public void crewasleep(CrewMember currentcrew) {
		currentcrew.sleep();
		currentcrew.subtractaction();
	}
	public void eat(CrewMember currentcrew, Food_Item food) {
		int remove = -1;
		int index = -1;
		for(Food_Item myfood: crew_food) {
			index +=1;
			if(food.getFoodName() == myfood.getFoodName()) {
				myfood.subtractQuantity();
				if(myfood.getQuantity() == 0 ) {
					remove = index;
				}
			}
		}
	}
		public void useemditem(CrewMember currentcrew, Medical_Item med) {
			int remove = -1;
			int index = -1;
			for(Medical_Item mymed: crew_medical) {
				index +=1;
				if(med.getMedName() == mymed.getMedName()) {
					med.subtractQuantity();
					if(med.getQuantity() == 0 ) {
						remove = index;
					}
				}
			}
		if(remove > -1) {
			crew_medical.remove(remove);
		}
		for (CrewMember crew: crew_members) {
			if(currentcrew == crew) {
				crew.addhealth(med.getHealthAdd());
				crew.subtractaction();
			}
		}
	}
	public void repair(CrewMember currentcrew) {
		currentcrew.subtractaction();
		if(currentcrew.viewtype() == "Technician") {
			shieldhealth += 11;
		} else if(currentcrew.viewtype() == "Superman") {
			shieldhealth += 8;
		} else {
			shieldhealth += 4;
		}
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
	public void alienpary() {
		boolean remove = false;
		int remove_index = -1;
		while (remove == false) {
			int item_type = rand.nextInt(2);
			if(item_type == 0) {
				int i = rand.nextInt(crew_food.size());
				int index  = -1;
			    for(Food_Item myfood: crew_food) {
			    index+=1;
				if(index == i) {
					myfood.subtractQuantity();
					remove = true;
					if(myfood.getQuantity() == 0) {
						remove_index = index;
					}
					
				}
			}
			    if(remove_index > -1) {
			    	crew_food.remove(remove_index);
			    }
		} else  {
			int i = rand.nextInt(crew_medical.size());
			int index  = -1;
		    for(Medical_Item mymed: crew_medical) {
		    index+=1;
			if(index == i) {
				mymed.subtractQuantity();
				remove = true;
				if(mymed.getQuantity() == 0) {
					remove_index = index;
				}
				
			}
		}
		    if(remove_index > -1) {
		    	crew_medical.remove(remove_index);
		    }
	}
	}
	}
	public static void main(String arg[]) {
		CrewMember hungryboy = new HungryBoy();
		CrewMember technician = new Technician();
		hungryboy.setname("Play1-Hungyboy");
		technician.setname("Player2-Technician");
		GameManager crew = new GameManager("The Space Invaders", "Normandy");
		crew.addCrew(hungryboy);
		crew.addCrew(technician);
		crew.printStatus();
		crew.setFoodstore();
		crew.setMedicalstore();
		Medical_Item largepack = new LargeMedPack();
		Food_Item banana = new Banana();
		Food_Item butterchicken = new ButterChicken();
		crew.medPurchase(largepack);
		//crew.repair(technician);
		//crew.repair(hungryboy);
		//System.out.println(hungryboy.getaction());
		crew.newday();
		crew.foodPurchase(butterchicken);
		crew.foodPurchase(butterchicken);
		crew.foodPurchase(banana);
		crew.newday();
		//crew.eat(hungry, banana);
		//crew.useemditem(hungry, largepack);
		//System.out.println(crew.getCrewSize());
		//System.out.println(crew.getShipname());
		//System.out.println(crew.getMedical());
		///System.out.println(crew.getShieldhealth());
		crew.printStatus();
	}
	
}
