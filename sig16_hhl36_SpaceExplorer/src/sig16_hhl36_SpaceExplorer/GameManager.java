package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Implements a game manager class. Making the game playable from here.
 * Most of the environment of the game is contained here.
 * With some of the methods implemented usable by the player,
 * and methods for dealing with crew members, ship pilots, random events
 * planet outposts and others.
 */
public class GameManager {
	private String shipName;
	private String crewName;
	private int crewSize = 4;
	private double crewMoney = 200;
	private int shieldHealth = 100;
	private ArrayList<CrewMember> pilots = new ArrayList<CrewMember>();
	ArrayList<CrewMember> crew_members = new ArrayList<CrewMember>();
	ArrayList<Food_Item> crew_food = new ArrayList<Food_Item>();
	ArrayList<Medical_Item> crew_medical = new ArrayList<Medical_Item>();
	private ArrayList<Food_Item> food_sell = new ArrayList<Food_Item>();
	private ArrayList<Medical_Item> medical_sell = new ArrayList<Medical_Item>();
	public int day = 10;
	private int pieces;
	private boolean shipParts;
	public CrewMember selectcrew; 
	public String getteditem;
	public String randomevent;
	Random rand = new Random();
	
	/**
     * Get string representation of current day, for use with gui label.
     * @return Integer.toString(day) - String representation of current day.
     */
	public String getdays() {
		return Integer.toString(day);
	}
	
	/**
     * Gets size of array crew_members.
     * @return crew_members.size() - Size of array crew_members.
     */
	public int getcrewsize() {
		return crew_members.size();
	}
	
	/**
     * Sets number of crew(team) that player has chosen.
     * @return crewSize - Amount of crew selected.
     */
	public int crewsize() {
		return crewSize;
	}
	
	/**
     * Sets name of crew(team) that player has chosen.
     * @param name - Name given to crew(team).
     */
	public void setcrewname(String name) {
		crewName = name;
	}
	
	/**
     * Sets name of spaceship as chosen by player.
     * @param nameShip - Name of spaceship.
     */
	public void setshipname(String nameShip) {
		shipName = nameShip;
	}
	
	/**
     * Sets money of crew(team).
     * @param money - Current amount of money that the crew(team) holds.
     */
	public void setMoney(int money) {
		crewMoney = money;
	}
	
	/**
     * Sets day to current day of game, while also calling the calculate pieces method.
     * @param setday - Next day of game.
     */
	public void setDay(int setday) {
		day = setday;
		calculatePieces();
	}
	
	/**
     * Calculates and sets the amount of spaceship parts to find, depending on
     * the amount of days. The amount of spaceship parts is found by multiplying
     * the current day by 2/3.
     */
	public void calculatePieces() {
		double index = day * 2/3;
		pieces = (int) Math.floor(index);
	}
	
	/**
     * Gets the current amount of spaceship parts.
     * @return pieces - Current amount of spaceship parts.
     */
	public int getpices() {
		return pieces;
	}
	
	/**
     * Gets current amount of money held by the crew(team).
     * @return crewMoney - Current amount of money held by crew(team).
     */
	public double getmoney() {
		return crewMoney;
	}
	
	/**
     * Sets name of the crew(team) to a specified name by the player.
     * @param name - Name given to crew(team).
     */
	public void setCrewname(String name) {
		crewName = name;
	}
	
	/**
	 * This method is used by the player to search a planet for the missing spaceship parts, 
	 * using the chosen crew member. The events are chosen randomly, so there is a completely random
	 * choice of finding a medical item, food item or spaceship parts.
     * @param currentcrew - Current crew member chosen by player to complete the search for parts.
     */
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
							lengthindex += 1;
							if (lengthindex <= length) {
								if(myfood.getFoodName() == food.getFoodName()) {
									myfood.addQuantity();
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
				} else if (crew_medical.contains(med)){
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
		getteditem = "transporter parts " + type;
		pieces -=1;
		shipParts = true;
	}
	}
	
	/**
	 * This method is used by the player to move on to the next day. 
	 * It also resets the amount of actions for every crew member left.
	 * This method also calls the randomEvent() method from within, this is
	 * to make sure a random event occurs when moving on to the new day.
     */	
	public void newday() {
		int index = -1;
		int remove = -1;
		day -= 1;
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
		randomEvent();
	}
	
	/**
	 * This method sets up a food store which is a part of the space outpost
	 * the player can visit.
     */
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
	
	/**
	 * This method sets up a medical store which is a part of the space outpost
	 * the player can visit.
     */
	public void setMedicalstore() {
		Medical_Item largenedoack = new LargeMedPack();
		Medical_Item plaguecure = new PlagueCure();
		Medical_Item smallmedpack = new SmallMedPack();
		medical_sell.add(largenedoack);
		medical_sell.add(plaguecure);
		medical_sell.add(smallmedpack);
	}
	
	/**
	 * This method allows the player to see items that are being sold in
	 * the medical store.
	 * @return string - String representation of medical items.
     */
	public String viewMed() {
		String string = "";
		for (Medical_Item item: medical_sell) {
			string += item.getMedName() + "\n";
			string += "Price :" + Double.toString(item.getPrice()) + "\n";
			string += "Health add: " + item.getHealthAdd() + "\n";
		}
		return string;
	}
	
	/**
	 * This method allows the player to see items that are being sold in
	 * the food store.
	 * @return string - String representation of food items.
     */
	public String viewFood() {
		String string ="";
		for(Food_Item item: food_sell) {
			string += item.getFoodName() +"\n";
			string += "Price: "+ Double.toString(item.getPrice()) +"\n";
			string += "Nutrition: "+item.getFoodNutrition() +"\n";
		}
		return string;
	}
	
	/**
	 * This method gets food items from the crews list of available food.
	 * @return food - String representation of food items available to crew(team).
     */
	public String getFood() {
		String food = "";
		for(Food_Item myfood: crew_food) {
			food += "\nFood name:" + myfood.getFoodName();
			food += "\nNutrition :" + myfood.getFoodNutrition();
			food += "\nQuantity :" + myfood.getQuantity() + "\n";
		}
		return food;
	}
	
	/**
	 * This method gets medical items from the crews list of available food.
	 * @return med - String representation of medical items available to crew(team).
     */
	public String getMedical() {
		String med = "";
		for(Medical_Item mymed: crew_medical) {
			med += "\nFood name:" + mymed.getMedName();
			med += "\nNutrition :" + mymed.getHealthAdd();
			med += "\nQuantity :" + mymed.getQuantity() + "\n";
		}
		return med;
	}
	
	/**
	 * This method allows the player to purchase food from the food store in the outpost
	 * and adds the purchased food to the crew supply.
	 * @param object - Food item object selected by player.
     */
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
	
	/**
	 * This method allows the player to purchase medical items from the medical store
	 * in the outpost and adds the purchased medical item to the crew supply.
	 * @param object - Medical item object selected by player.
     */
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
	
	/**
	 * This method allows the player to make the selected crew member
	 * go to sleep. Also subtracts an action from the crew member while doing so.
	 * @param currentcrew - Current crew member object selected by player.
     */
	public void crewasleep(CrewMember currentcrew) {
		currentcrew.sleep();
		currentcrew.subtractaction();
	}
	
	/**
	 * This method allows the player to feed the selected crew member
	 * with a selected food item. This method also subtracts an action from 
	 * the chosen crew member.
	 * @param currentcrew - current crew member object selected by user.
	 * @param food - Food item chosen by player.
     */
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
	
	/**
	 * This method allows the player to heal the selected crew member
	 * with a selected medical item. This method also subtracts an action from 
	 * the chosen crew member.
	 * @param currentcrew - current crew member object selected by user.
	 * @param med - Medical item chosen by player.
     */
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
	
	/**
	 * This method allows the player to repair the spaceship with the
	 * selected crew member. This method also subtracts an action from 
	 * the chosen crew member.
	 * @param currentcrew - current crew member object selected by user.
     */
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
	
	/**
	 * Gets name of the spaceship.
	 * @return shipName - Name given to ship by player.
     */
	public String getShipname() {
		return shipName;
	}
	
	/**
	 * Gets name of the crew(team).
	 * @return crewName - Name given to crew(team) by player.
     */
	public String getCrewname() {
		return crewName;
	}
	
	/**
	 * Sets the size of the crew(team).
	 * @param size - Current size of crew(team).
     */
	public void setCrewSize(int size) {
		crewSize = size;
	}
	
	/**
	 * Gets spaceship shield health.
	 * @return shieldHealth - Current health of the spaceship shield.
     */
	public int getShieldhealth() {
		return shieldHealth;
	}
	
	/**
	 * Adds chosen crew member to crew(team) array.
	 * @param crew - Crew member object chosen by player.
     */
	public void addCrew(CrewMember crew) {
		crew_members.add(crew);
		
	}
	
	/**
	 * Gets status of all crew members that are in the current crew(team).
     */
	public void printStatus() {
		for (CrewMember crewmember: crew_members) {
			System.out.println(crewmember.viewStatus() + "\n");
		}
	}
	
	/**
	 * Calculates final score for when the game ends. Score depends on
	 * spaceship shield health, amount of spaceship parts left, amount of crew members left
	 * and the amount of money left over.
	 * @return gamescore - Final game score.
     */
	public double Calaulatescore() {
		double gamescore = 0;
		gamescore += shieldHealth * 10;
		gamescore -= pieces * 200;
		gamescore -= crewSize - crew_members.size() * 40;
		gamescore += crewMoney *10;
		if(pieces == 0) {
			gamescore +=1000;
		}
		return gamescore;
	}
	
	/**
	 * This method is in charge of the random event alien pirates that occurs
	 * when moving to a new planet or new day. The alien pirates board the
	 * spaceship while having a random possibility of stealing a medical item or
	 * food item.
     */
//	public void alienparty() {
//		randomevent = "Alien pirates";
//		int item_type = rand.nextInt(2);
//		boolean remove = false;
//		if (remove == false) {
//			switch(item_type) {
//			case 0:
//				if(crew_food.size() > 0) {
//					int i = rand.nextInt(crew_food.size());
//					int index  = -1;
//				    for(Food_Item myfood: crew_food) {
//					    index += 1;
//						if(index == i) {
//							myfood.subtractQuantity();
//							remove = true;
//							if(myfood.getQuantity() == 0) {
//								remove_index = index;
//							}
//						}
//				    }
//				    if(remove_index > -1) {
//				    	crew_food.remove(remove_index);
//				    }
//				}
//				
//			}
//		}
//	}
	public void alienparty() {
		randomevent = "Alien pirates";
		boolean remove = false;
		int remove_index = -1;
		while (remove == false) {
			int item_type = rand.nextInt(2);
			if(item_type == 0) {
				if(crew_food.size() > 0) {
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
				}
			  } else {
				  if(crew_medical.size() > 0) {
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
	}
	
	/**
	 * This method is in charge of the random event space plague that occurs
	 * when moving to a new planet or new day. When the space plague occurs
	 * any of the crew members have a random possibility of 
	 * contracting the plague.
     */
	public void spaceplague() {
		randomevent = "Space plague";
		for(CrewMember crew :crew_members) {
			boolean bool =  rand.nextBoolean();
			if(bool == true) {
				crew.sick();
			}
		}
	}
	
	/**
	 * This method is in charge of the random event asteroid belt that occurs
	 * when moving to a new planet or new day. When the asteroid belt occurs
	 * the spaceship loses shield health by 30% of the total shield health every tiome.
     */
	public void asteroidBelt() {
		randomevent ="Asteroid belt";
		shieldHealth = (int) (getShieldhealth() - (100 * 0.3));
	}
	
	/**
	 * This method is in charge of randomising the the asteroid belt, space plague
	 * and alien pirate events.
     */
	public void randomEvent() {
		int randint = new Random().nextInt(3);
		if(crew_food.size() > 0 || crew_medical.size() > 0) {
			switch (randint) {
				case 0: 
					spaceplague();
					break;
				case 1: 
					alienparty();
					break;
				case 2:
					asteroidBelt();
					break;
			}
		} else {
			switch (randint) {
				case 0: 
					spaceplague();
					break;
				case 1: 
					alienparty();
					break;
				case 2:
					asteroidBelt();
					break;
			}
		}
	}
		//if(crew_food.size() > 0 || crew_medical.size() > 0) {
			//int randint1 = new Random().nextInt(3);
	        //switch (randint1) {
	           //case 0: spaceplague();
	           //case 1: alienparty();
	           //case 2: asteroidBelt();
	        //}		
		//} //else {
			//int randint2 = new Random().nextInt(2);
	        //switch (randint2) {
	           //case 0: spaceplague();
	           //case 1: asteroidBelt();
	        //}
		//}
	//}
	public void newPlanet(CrewMember member1, CrewMember member2) {
		member2.action -=1;
		member1.action -=1;
		randomEvent();
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
		launchScore();
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
	public void gotoScore(Peform peforeWindows) {
		peforeWindows.closeWindow();
		launchScore();
	}
	public void launchScore() {
		Score scoreWindows = new Score(this);
	}
	public void closeScore(Score scoreWindows) {
		scoreWindows.closeWindow();
	}
	public void launchPilot() {
		Pilot pilotWindows = new Pilot(this);
	}
	public void closePilot(Pilot pilotWindows) {
		pilotWindows.closeWindow();
		launchMainScreen();
	}
	public void gotoPilot(Peform peforeWindows) {
		peforeWindows.closeWindow();
		launchPilot();
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
		manager.launchSetupScreen();
		/*CrewMember hungryboy = new HungryBoy();
		CrewMember lazyslepper = new LazySleeper();
		manager.newPlannet(hungryboy, lazyslepper);
		System.out.println(hungryboy.viewStatus());
		System.out.println(lazyslepper.viewStatus());
		manager.setDay(7);*/
		/*Food_Item butterchicken = new ButterChicken();
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
