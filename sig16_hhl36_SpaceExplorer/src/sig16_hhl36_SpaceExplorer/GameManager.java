package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class GameManager {
	private String shipName;
	private String crewName;
	private int crewSize;
	private double crewMoney;
	private int shieldHealth;
	private ArrayList<CrewMember> pilots = new ArrayList<CrewMember>();
	private ArrayList<CrewMember> pilot_candidate = new ArrayList<CrewMember>();
	private ArrayList<CrewMember> crew_members = new ArrayList<CrewMember>();
	private ArrayList<Food_Item> crew_food = new ArrayList<Food_Item>();
	private ArrayList<Medical_Item> crew_medical = new ArrayList<Medical_Item>();
	private ArrayList<Food_Item> food_sell = new ArrayList<Food_Item>();
	private ArrayList<Medical_Item> medical_sell = new ArrayList<Medical_Item>();
	private int day;
	private int pieces;
	private boolean shipParts;
	Random rand = new Random();
	
	public GameManager() {
		shipName = "";
		crewName = "";
		crewSize = 0;
		crewMoney = 100.0;
		shieldHealth = 100;
	}
	public void setcrewname(String name) {
		crewName = name;
	}
	public void setshipname(String name) {
		shipName = name;
	}
	public void setMoney(int money) {
		crewMoney = money;
	}
	public void setDay(int setday) {
		day = setday;
		calculatePieces();
	}
	public void setShipname(String name) {
		shipName = name;
	}
	public void calculatePieces() {
		double index = day*2/3;
		pieces = (int) Math.floor(index);
	}
	public int getpices() {
		return pieces;
	}
	public double getmoney() {
		return crewMoney;
	}
	public void setCrewname(String name) {
		crewName = name;
	}
	public void searchParts() {
		int type = -1;
		if(shipParts == false) {
			type = rand.nextInt(3);
		} else {
			type = rand.nextInt(2);
		}
		if(type == 0) {
			int random_index = rand.nextInt(6);
			int index = 0;
			int length = crew_food.size();
			int lengthindex = 0;
			for (Food_Item food: food_sell) {
				if(index == random_index) {
					System.out.println("JFKJFBKSJBD");
					System.out.println(food.getFoodName());
					for(Food_Item myfood: crew_food) {
						lengthindex += 1;
						if (lengthindex <= length) {
							if(myfood.getFoodName() == food.getFoodName()) {
								myfood.addQuantity();
							}
						} else {
							food.addQuantity();
							crew_food.add(food);
						}
					}
				}
				index += 1;
			} 
	} else if (type == 2) {
		int random_index = rand.nextInt(3);
		int index = 0;
		int length = crew_medical.size();
		int lengthindex = 0;
		
		for (Medical_Item med: medical_sell) {
			if(index == random_index) {
				for(Medical_Item mymed: crew_medical) {
					lengthindex+=1;
					if (lengthindex <= length) {
						if(mymed.getMedName() == med.getMedName()) {
							mymed.addQuantity();}
					} else {
						med.addQuantity();
						crew_medical.add(med);
					}
				}
			}
			index += 1;
		}
	} else {
		pieces -=1;
	}
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
			food += "\nQuantity :" + myfood.getQuantity() + "\n";
	}
		return food;
	}
	public String getMedical() {
		String med ="";
		for(Medical_Item mymed: crew_medical) {
			med += "\nFood name:" + mymed.getMedName();
			med += "\nNutrition :" + mymed.getHealthAdd();
			med += "\nQuantity :" + mymed.getQuantity() + "\n";
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
		if(remove > -1) {
			crew_food.remove(remove);
		}
		for (CrewMember crew: crew_members) {
			if(currentcrew == crew) {
				crew.addnutrition(food.getFoodNutrition());
				crew.subtractaction();
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
				if(med.getMedName() == "Space Plague Curer") {
					crew.recovery();
				}
				crew.addhealth(med.getHealthAdd());
				crew.subtractaction();
			}
		}
	}
	public void repair(CrewMember currentcrew) {
		currentcrew.subtractaction();
		if(currentcrew.viewtype() == "Technician") {
			shieldHealth += 11;
		} else if(currentcrew.viewtype() == "Superman") {
			shieldHealth += 8;
		} else {
			shieldHealth += 4;
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
		return shieldHealth;
	}
	
	public void setShieldhealth(int shield_health) {
		shieldHealth = shield_health;
	}
	
	public void addCrew(CrewMember crew) {
		int count = crew_members.size();
		crew_members.add(crew);
		setCrewSize(count + 1);
	}
	
	public void printAllCrewMembers() {
		for (CrewMember crewmember: crew_members) {
			System.out.println(crewmember.viewtype() + "\n");
		}
	}
	public void printStatus() {
		for (CrewMember crewmember: crew_members) {
			System.out.println(crewmember.viewStatus() + "\n");
		}
	}
	public void spaceshipStatus() {
		System.out.println("The " + getShipname() + "has a shield health of " + getShieldhealth());
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
	public void spaceplague() {
		for(CrewMember crew :crew_members) {
			boolean bool =  rand.nextBoolean();
			if(bool == true) {
				crew.sick();
			}
		}
	}
	
	public void asteroidBelt() {
		int shield_health = getShieldhealth();
		shield_health -= (shield_health * 0.2);
		setShieldhealth(shield_health);
	}
	
	public void setPilot() {
		String print = "";
		Scanner input = new Scanner(System.in);
		try {
			for (CrewMember crewmate: pilot_candidate) {
				print += pilot_candidate.indexOf(crewmate) + ": " + crewmate;
			}
			System.out.println("Please select the number beside your chosen crew member: ");
			System.out.println(print);
			int num = input.nextInt();
			pilots.add();
		} finally {
			input.close();
		}
		
	}
	
	public void newPlanet() throws PilotCrewException {
		if (getCrewSize() >= 2) {
				for (CrewMember crewmember: crew_members) {
					if (crewmember.getaction() >= 1) {
						pilot_candidate.add(crewmember);
					} else {
						System.out.println("Crew Member: " + crewmember + " is out of actions!");
					}
				}
				if (pilot_candidate.size() >= 2) {
					setPilot();
				} else {
					throw new PilotCrewException("Don't have enough Crew Members for this action!");
				}
		} else {
				throw new PilotCrewException("Don't have enough Crew Members for this action!");
		}
	}
	
	public static void main(String arg[]) {
		GameManager crew = new GameManager();
		// test all six characters
		CrewMember hungryboy = new HungryBoy();
		CrewMember hunk = new Hunk();
		CrewMember lazyslepper = new LazySleeper();
		CrewMember seeker = new Seeker();
		CrewMember superman = new Superman();
		CrewMember technician = new Technician();
		//set up name for characters
		hungryboy.setname("Player1-hungryboy");
		hunk.setname("Player2-hunk");
		lazyslepper.setname("Player3-lazysleeper");
		seeker.setname("Player4-seeker");
		superman.setname("Player5-superman");
		technician.setname("Player6-technician");
		//add those six characters in the crew_manber array
		crew.addCrew(hungryboy);
		crew.addCrew(hunk);
		crew.addCrew(lazyslepper);
		crew.addCrew(seeker);
		crew.addCrew(superman);
		crew.addCrew(technician);
		//print all status of crew
		System.out.println("All status before start");
		crew.printStatus();
		//test pieces with correct day
		crew.setDay(7);
		System.out.println("Pieces:");
		System.out.println(crew.getpices());
		//set up all six foods
		Food_Item banana = new Banana();
		Food_Item butterchicken = new ButterChicken();
		Food_Item hamsandwihes = new HamSandwiches();
		Food_Item peaches = new Peaches();
		Food_Item spaghetti_bolonese = new SpaghettiBolognese();
		Food_Item straeberries = new Strawberries();
		//test purchase food item 
		crew.setFoodstore();
		crew.foodPurchase(banana);
		crew.foodPurchase(butterchicken);
		crew.foodPurchase(hamsandwihes);
		crew.foodPurchase(peaches);
		crew.foodPurchase(spaghetti_bolonese);
		crew.foodPurchase(straeberries);
		crew.foodPurchase(banana);
		System.out.println(crew.getFood());
		System.out.println(crew.getmoney());
		//set up all three medical items
		Medical_Item plagurcure = new PlagueCure();
		Medical_Item samllmedpack = new SmallMedPack();
		Medical_Item bigmedpack = new LargeMedPack();
		crew.setMedicalstore();
		//test purchase medical item 
		crew.medPurchase(plagurcure);
		crew.medPurchase(samllmedpack);
		crew.medPurchase(bigmedpack);
		System.out.println(crew.getMedical());
		System.out.println(crew.getmoney());
		//test eat function 
		//crew.newday();
		//crew.eat(hungryboy, strawberries);
		//crew.eat(hungryboy, butterchicken);
		//test use medical function 
		//crew.useemditem(hunk, smallmedpack);
		//test party
		//crew.alienpary();
		//test space plague
		//crew.spaceplague();
		//System.out.println(crew.getFood());
		//System.out.println(crew.getMedical());
		System.out.println(crew.getFood());
		System.out.println(crew.getMedical());
		System.out.println(crew.pieces);
		crew.searchParts();
		crew.newPlanet();
		
	}
	
}
