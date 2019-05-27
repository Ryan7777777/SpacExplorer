package sig16_hhl36_SpaceExplorer;

import java.util.ArrayList;
import java.util.Random;

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
	private int shieldHealth = 200;
	ArrayList<CrewMember> crew_members = new ArrayList<CrewMember>();
	ArrayList<FoodItem> crew_food = new ArrayList<FoodItem>();
	ArrayList<MedicalItem> crew_medical = new ArrayList<MedicalItem>();
	private ArrayList<FoodItem> food_sell = new ArrayList<FoodItem>();
	private ArrayList<MedicalItem> medical_sell = new ArrayList<MedicalItem>();
	public int day = 10;
	private int pieces;
	private boolean shipParts;
	public CrewMember selectCrew; 
	public String foundItem;
	public String randomeventName;
	Random rand = new Random();
	
	/**
     * Get string representation of current day, for use with gui label.
     * @return Integer.toString(day) - String representation of current day.
     */
	public String getDays() {
		return Integer.toString(day);
	}
	
	/**
     * Gets size of array crew_members.
     * @return crew_members.size() - Size of array crew_members.
     */
	public int getCrewSize() {
		return crew_members.size();
	}
	
	/**
     * Sets number of crew(team) that player has chosen.
     * @return crewSize - Amount of crew selected.
     */
	public int crewSize() {
		return crewSize;
	}
	
	/**
     * Sets name of crew(team) that player has chosen.
     * @param name - Name given to crew(team).
     */
	public void setcrewName(String name) {
		crewName = name;
	}
	
	/**
     * Sets name of spaceship as chosen by player.
     * @param nameShip - Name of spaceship.
     */
	public void setshipName(String nameShip) {
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
	public int getPieces() {
		return pieces;
	}
	
	/**
     * Gets current amount of money held by the crew(team).
     * @return crewMoney - Current amount of money held by crew(team).
     */
	public double getMoney() {
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
	public void searchParts(CrewMember currentCrew) {
		currentCrew.subtractAction();
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
			int lengthIndex = 0;
			for (FoodItem food: food_sell) {
				if(index == random_index) {
					foundItem = food.getFoodName();
					if(crew_food.size() == 0) {
						food.addQuantity();
						crew_food.add(food);
					} else if (crew_food.contains(food)){
						for(FoodItem myfood: crew_food) {
							lengthIndex += 1;
							if (lengthIndex <= length) {
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
		for (MedicalItem med: medical_sell) {
			if(index == random_index) {
				foundItem = med.getMedName();
				if(crew_medical.size() == 0) {
					med.addQuantity();
					crew_medical.add(med);
				} else if (crew_medical.contains(med)){
					for(MedicalItem mymed: crew_medical) {
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
		foundItem = "nothing";
	} else {
		foundItem = "transporter parts " + type;
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
	public void newDay() {
		ArrayList<CrewMember> toRemove= new ArrayList<CrewMember>();
		day -= 1;
		for (CrewMember crew: crew_members) {
			crew.resetAction();
			if(crew.isSick() == true) {
				crew.sickLost(10);
			}
			crew.newDay_status();
			if(crew.getHealth() <=0) {
				toRemove.add(crew);
		}
		}
		crew_members.removeAll(toRemove);
		randomEvent();
	}
	
	/**
	 * This method sets up a food store which is a part of the space outpost
	 * the player can visit.
     */
	public void setFoodstore() {
		FoodItem peach = new Peaches();
		FoodItem butterChicken = new ButterChicken();
		FoodItem banana = new Banana();
		FoodItem hamSandwiches = new HamSandwiches();
		FoodItem strawberry = new Strawberries();
		FoodItem spaghetti = new SpaghettiBolognese();
		food_sell.add(peach);
		food_sell.add(butterChicken);
		food_sell.add(hamSandwiches);
		food_sell.add(strawberry);
		food_sell.add(spaghetti);
		food_sell.add(banana);
	}
	
	/**
	 * This method sets up a medical store which is a part of the space outpost
	 * the player can visit.
     */
	public void setMedicalstore() {
		MedicalItem largeMedpack = new LargeMedPack();
		MedicalItem plaguecure = new PlagueCure();
		MedicalItem smallMedpack = new SmallMedPack();
		medical_sell.add(largeMedpack);
		medical_sell.add(plaguecure);
		medical_sell.add(smallMedpack);
	}
	
	/**
	 * This method allows the player to see items that are being sold in
	 * the medical store.
	 * @return string - String representation of medical items.
     */
	public String viewMed() {
		String string = "";
		for (MedicalItem item: medical_sell) {
			string += item.getMedName() + "\n";
			string += "Price :" + Double.toString(item.getPrice()) + "\n";
			string += "Health add: " + item.getHealthAdd() + "\n\n";
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
		for(FoodItem item: food_sell) {
			string += item.getFoodName() + "\n";
			string += "Price: "+ Double.toString(item.getPrice()) + "\n";
			string += "Nutrition: " + item.getFoodNutrition() + "\n\n";
		}
		return string;
	}
	
	/**
	 * This method gets food items from the crews list of available food.
	 * @return food - String representation of food items available to crew(team).
     */
	public String getFood() {
		String food = "";
		for(FoodItem myfood: crew_food) {
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
		for(MedicalItem mymed: crew_medical) {
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
	public void foodPurchase(FoodItem object) {
		crewMoney = crewMoney - object.getPrice();
		if(crew_food.contains(object)) {
			for(FoodItem myfood: crew_food) {
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
	public void medPurchase(MedicalItem object) {
		crewMoney = crewMoney - object.getPrice();
		if(crew_medical.contains(object)) {
			for(MedicalItem mymed: crew_medical) {
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
	 * @param currentCrew - Current crew member object selected by player.
     */
	public void crewAsleep(CrewMember currentCrew) {
		currentCrew.sleep();
		currentCrew.subtractAction();
	}
	
	/**
	 * This method allows the player to feed the selected crew member
	 * with a selected food item. This method also subtracts an action from 
	 * the chosen crew member.
	 * @param currentCrew - current crew member object selected by user.
	 * @param food - Food item chosen by player.
     */
	public void eat(CrewMember currentCrew, FoodItem food) {
		int remove = -1;
		int index = -1;
		for(FoodItem myfood: crew_food) {
			index += 1;
			if(food.getFoodName() == myfood.getFoodName()) {
				myfood.subtractQuantity();
				if(myfood.getQuantity() == 0) {
					remove = index;
				}
			}
		}
		if(remove > -1) {
			crew_food.remove(remove);
		}
		for (CrewMember crew: crew_members) {
			if(currentCrew == crew) {
				crew.addNutrition(food.getFoodNutrition());
				crew.subtractAction();
			}
		}	
	}
	
	/**
	 * This method allows the player to heal the selected crew member
	 * with a selected medical item. This method also subtracts an action from 
	 * the chosen crew member.
	 * @param currentCrew - current crew member object selected by user.
	 * @param med - Medical item chosen by player.
     */
	public void useMedItem(CrewMember currentCrew, MedicalItem med) {
		int remove = -1;
		int index = -1;
		for(MedicalItem mymed: crew_medical) {
			index += 1;
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
			if(currentCrew == crew) {
				if(med.getMedName() == "Space Plague Curer") {
					crew.recovery();
				}
				crew.addHealth(med.getHealthAdd());
				crew.subtractAction();
			}
		}
	}
	
	/**
	 * This method allows the player to repair the spaceship with the
	 * selected crew member. This method also subtracts an action from 
	 * the chosen crew member.
	 * @param currentCrew - current crew member object selected by user.
     */
	public void repair(CrewMember currentCrew) {
		currentCrew.subtractAction();
		if(currentCrew.viewType() == "Technician") {
			shieldHealth += 11;
		} else if(currentCrew.viewType() == "Superman") {
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
	 * @return gameScore - Final game score.
     */
	public double calcScore() {
		double gameScore = 0;
		gameScore += shieldHealth * 10;
		gameScore -= pieces * 200;
		gameScore -= crewSize - crew_members.size() * 40;
		gameScore += crewMoney *10;
		if(pieces == 0) {
			gameScore +=1000;
		}
		return gameScore;
	}
	
	/**
	 * This method is in charge of the random event alien pirates that occurs
	 * when moving to a new planet or new day. The alien pirates board the
	 * spaceship while having a random possibility of stealing a medical item or
	 * food item.
     */
	public void alienPirates() {
		randomeventName = "Alien Pirates";
		boolean remove = false;
		int remove_index = -1;
		while (remove == false) {
			int item_type = rand.nextInt(2);
			if(item_type == 0) {
				if(crew_food.size() > 0) {
					int i = rand.nextInt(crew_food.size());
					int index  = -1;
				    for(FoodItem myfood: crew_food) {
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
					  for(MedicalItem mymed: crew_medical) {
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
	public void spacePlague() {
		randomeventName = "Space Plague";
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
		randomeventName ="Asteroid Belt";
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
					spacePlague();
					break;
				case 1: 
					alienPirates();
					break;
				case 2:
					asteroidBelt();
					break;
			}
		} else {
			randint = new Random().nextInt(2);
			switch (randint) {
				case 0: 
					spacePlague();
					break;
				case 1:
					asteroidBelt();
					break;
			}
		}
	}
		
	public void newPlanet(CrewMember member1, CrewMember member2) {
		member2.action -= 1;
		member1.action -= 1;
		randomEvent();
	}

	public void launchMainScreen () {
		new mainGame(this);
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
		new setupGame(this);
	}
	public void closeSetupScreen(setupGame setupWindow) {
		setupWindow.closeWindow();
		launchMainScreen();
	}
	public void launchStore() {
		new Store(this);
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
		new Peform(this);
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
		new UseItem(this);
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
		new Score(this);
	}
	public void closeScore(Score scoreWindows) {
		scoreWindows.closeWindow();
	}
	public void launchPilot() {
		new Pilot(this);
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
		manager.setFoodstore();
		manager.setMedicalstore();
		manager.launchSetupScreen();
	}
	
}
