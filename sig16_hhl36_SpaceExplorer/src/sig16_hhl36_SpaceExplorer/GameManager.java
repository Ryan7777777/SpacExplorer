package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class GameManager {
	private String shipName;
	private String crewName;
	private int crewSize = 4;
	private double crewMoney = 100;
	private int shieldHealth = 100;
	private ArrayList<CrewMember> pilots = new ArrayList<CrewMember>();
	//private ArrayList<CrewMember> pilot_candidate = new ArrayList<CrewMember>();
	ArrayList<CrewMember> crew_members = new ArrayList<CrewMember>();
	ArrayList<Food_Item> crew_food = new ArrayList<Food_Item>();
	ArrayList<Medical_Item> crew_medical = new ArrayList<Medical_Item>();
	private ArrayList<Food_Item> food_sell = new ArrayList<Food_Item>();
	private ArrayList<Medical_Item> medical_sell = new ArrayList<Medical_Item>();
	private int day = 10;
	private int pieces;
	private boolean shipParts;
	public CrewMember selectcrew; 
	public String getteditem;
	Random rand = new Random();
	public String getdays() {
		return Integer.toString(day);
	}
	public int getcrewsize() {
		return crew_members.size();
	}
	public int crewsize() {
		return crewSize;
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
	public void searchParts(CrewMember currentcrew) {
		//currentcrew.subtractaction();
		int type = -1;
		if(shipParts == false) {
			type = rand.nextInt(5);
		} else {
			type = rand.nextInt(3);
		}
		if(type == 0) {
			int random_index = rand.nextInt(6);
			int index = 0;
			int length = crew_food.size();
			int lengthindex = 0;
			for (Food_Item food: food_sell) {
				if(index == random_index) {
					getteditem = food.getFoodName();
					if(crew_food.size() == 0) {
						food.addQuantity();
						crew_food.add(food);
					} else if (crew_food.contains(food)){
						for(Food_Item myfood: crew_food) {
							for(Food_Item myfood: crew_food) {
								lengthindex += 1;
								if (lengthindex <= length) {
									if(myfood.getFoodName() == food.getFoodName()) {
										myfood.addQuantity();
									}
								}
							}
						}
							} else {
								food.addQuantity();
								crew_food.add(food);
							}
						}
				index += 1;
			} 
		} else if (type == 1) {
		int random_index = rand.nextInt(3);
		int index = 0;
		int length = crew_medical.size();
		int lengthindex = 0;
		for (Medical_Item med: medical_sell) {
			if(index == random_index) {
				getteditem = med.getMedName();
				if(crew_medical.size() == 0) {
					med.addQuantity();
					crew_medical.add(med);
				} else if (crew_medical.contains(med)) {
					for(Medical_Item mymed: crew_medical) {
						if(mymed.getMedName() == med.getMedName()) {
							mymed.addQuantity();
						}
					}
				} else {
					med.addQuantity();
					crew_medical.add(med);
				}
			}
			index += 1;
		}
	} else if(type == 2){
		getteditem = "nothing";
	} else {
		getteditem = "transporter parts" + type;
		pieces -=1;
		shipParts = true;
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
	public String viewMed() {
		String string ="";
		for (Medical_Item item: medical_sell) {
			string += item.getMedName() +"\n";
			string += "Price :"+Double.toString(item.getPrice()) +"\n";
			string += "Health add: "+item.getHealthAdd() +"\n";
		}
		return string;
	}
	public String viewFood() {
		String string ="";
		for(Food_Item item: food_sell) {
			string += item.getFoodName() +"\n";
			string += "Price: "+ Double.toString(item.getPrice()) +"\n";
			string += "Nutrition: "+item.getFoodNutrition() +"\n";
		}
		return string;
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
		crew_members.add(crew);
		
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
	public void alienparty() {
		boolean remove = false;
		int remove_index = -1;
		while (remove == false) {
			int item_type = rand.nextInt(2);
			if(item_type == 0) {
				int i = rand.nextInt(crew_food.size());
				int index  = -1;
			    for(Food_Item myfood: crew_food) {
				    index += 1;
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
			  } else {
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
	public void randomEvent() {
		int randint = new Random().nextInt(3);
        switch (randint) {
           case 0: spaceplague();
           case 1: alienparty();
           case 2: asteroidBelt();
        }		
	}
	public void setPilot(ArrayList<CrewMember> pilot_candidate) throws PilotCrewException {
		String print = "Crew members availabe to be a pilot for the spaceship: ";
		if (pilot_candidate.size() < 2) {
			throw new PilotCrewException("Need at least two Crew Members to pilot a ship");
		} else {
			for (CrewMember pilot: pilot_candidate) {
				print += ", " + pilot_candidate.indexOf(pilot) + ": " + pilot.getName();
			}
			System.out.println(print);
			Scanner input = new Scanner(System.in);
			while (pilots.size() < 2) {
			    try { // checks code for exceptions
			        System.out.println("Please select the number beside the possible Crew Member pilot: ");
			        int index = input.nextInt();
			        pilots.add(pilot_candidate.get(index));
				} catch (InputMismatchException e) { //if an exception appears prints message below
				    System.err.println("Please enter a number! " + e.getMessage());
				    input.next(); 
				    continue;
				}
			}
			input.close();
		}
		System.out.println(getPilot());
	}
	public String getPilot() {
		String print = "Your pilots are: \n";
		
		for (CrewMember pilot: pilots) {
			print += pilot.getName() + "\n";
		}
		return print;
	}
	public void newPlanet() throws PilotCrewException {
		ArrayList<CrewMember> pilot_candidate = new ArrayList<CrewMember>();

		if (getcrewsize() >= 2) {
				for (CrewMember crewmember: crew_members) {
					if (crewmember.getaction() >= 1) {
						pilot_candidate.add(crewmember);
					} else {
						System.out.println("Crew Member: " + crewmember + " is out of actions!");
					}
				}
		} else {
				throw new PilotCrewException("Don't have enough Crew Members for this action!");
		}
		setPilot(pilot_candidate);
		randomEvent();
	}
	public void launchMainScreen () {
		mainGame mainWindow = new mainGame(this);
	}
	public void closeMainScreen(mainGame mainWindow) {
		mainWindow.closeWindow();
	}
	public void gotoStore(mainGame mainWindow) {
		mainWindow.closeWindow();
		launchStore();
	}
	public void launchSetupScreen() {
		calculatePieces();
		setupGame setupWindow = new setupGame(this);
	}
	public void closeSetupScreen(setupGame setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	public void launchStore() {
		Store storeWindows = new Store(this);
	}
	public void closeStore(Store storeWindows) {
		storeWindows.closeWindow();
		launchMainScreen();
	}
	public void gotoPeform(mainGame mainWindow) {
		mainWindow.closeWindow();
		launchPeform();
	}
	public void launchPeform() {
		Peform peforeWindows = new Peform(this);
	}
	public void closePeform(Peform peforeWindows) {
		peforeWindows.closeWindow();
		launchMainScreen();
	}
	public void gotoUseItem(Peform peforeWindows) {
		peforeWindows.closeWindow();
		launchUseItem();
	}
	public void launchUseItem() {
		UseItem itemWindows = new UseItem(this);
	}
	public void closeUseItem(UseItem itemWindows) {
		itemWindows.closeWindow();
		launchMainScreen();
	}
	public static void main(String arg[]) {
		GameManager manager = new GameManager();
		Food_Item banana = new Banana();
		Food_Item butterchicken = new ButterChicken();
		Food_Item hamsandwihes = new HamSandwiches();
		Food_Item peaches = new Peaches();
		Food_Item spaghetti_bolonese = new SpaghettiBolognese();
		Food_Item straeberries = new Strawberries();
		Medical_Item plagurcure = new PlagueCure();
		Medical_Item samllmedpack = new SmallMedPack();
		Medical_Item bigmedpack = new LargeMedPack();
		manager.setFoodstore();
		manager.setMedicalstore();
		/*CrewMember hungryboy = new HungryBoy();
		CrewMember lazyslepper = new LazySleeper();
		manager.setDay(7);
		Food_Item butterchicken = new ButterChicken();
		Food_Item hamsandwihes = new HamSandwiches();
		Food_Item peaches = new Peaches();
		Food_Item spaghetti_bolonese = new SpaghettiBolognese();
		Food_Item straeberries = new Strawberries();
		manager.addCrew(hungryboy);
		manager.addCrew(lazyslepper);
		manager.searchParts(hungryboy);
		manager.searchParts(hungryboy);
		manager.searchParts(lazyslepper);
		manager.searchParts(lazyslepper);
		*/
		manager.launchSetupScreen();
		/*Food_Item banana = new Banana();
		Food_Item butterchicken = new ButterChicken();
		Food_Item hamsandwihes = new HamSandwiches();
		Food_Item peaches = new Peaches();
		Food_Item spaghetti_bolonese = new SpaghettiBolognese();
		Food_Item straeberries = new Strawberries();
		manager.setFoodstore();
		Medical_Item plagurcure = new PlagueCure();
		Medical_Item samllmedpack = new SmallMedPack();
		Medical_Item bigmedpack = new LargeMedPack();
		manager.setMedicalstore();
		// test all six characters
		CrewMember hungryboy = new HungryBoy();
		/*CrewMember hunk = new Hunk();
		CrewMember lazyslepper = new LazySleeper();
		CrewMember seeker = new Seeker();
		CrewMember superman = new Superman();
		CrewMember technician = new Technician();
		set up name for characters*/
		//hungryboy.setname("Player1-hungryboy");
		/*hunk.setname("Player2-hunk");
		lazyslepper.setname("Player3-lazysleeper");
		seeker.setname("Player4-seeker");
		superman.setname("Player5-superman");
		technician.setname("Player6-technician");
		add those six characters in the crew_manber array*/
		//manager.addCrew(hungryboy);
		/*crew.addCrew(hunk);
		crew.addCrew(lazyslepper);
		crew.addCrew(seeker);
		crew.addCrew(superman);
		crew.addCrew(technician);
		print all status of crew
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
		crew.setFoodstore();*/
		/*manager.foodPurchase(banana);
		manager.foodPurchase(banana);
		manager.foodPurchase(banana);
		manager.foodPurchase(butterchicken);
		manager.foodPurchase(butterchicken);
		manager.foodPurchase(hamsandwihes);
		manager.foodPurchase(hamsandwihes);
		/*crew.foodPurchase(peaches);
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
		test eat function 
		crew.newday();
		crew.eat(hungryboy, strawberries);
		crew.eat(hungryboy, butterchicken);
		test use medical function 
		crew.useemditem(hunk, smallmedpack);
		test party
		crew.alienpary();
		test space plague
		crew.spaceplague();*/
		//System.out.println(manager.getFood());
		/*System.out.println(crew.getMedical());
		System.out.println(crew.getFood());
		System.out.println(crew.getMedical());
		System.out.println(crew.pieces);
		crew.searchParts();
		crew.newPlanet();*/
		
	}
	
}
