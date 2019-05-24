package sig16_hhl36_SpaceExplorer;

/**
 * Implements a food item class, used for events relating to food
 * available to be used by a crew member.
 */
public class FoodItem {
	
	private double foodPrice;
	private int foodNutrition;
	private String foodName;
	private int quantity;
	
    /**
     * Create a new food item.
     * @param price - The price of the food item.
     * @param nutrition - Nutritional value of the food item.
     * @param name - Name of the food item
     */
	public FoodItem(double price, int nutrition, String name) {
		foodPrice = price;
		foodNutrition = nutrition;
		foodName = name;
		quantity = 0;
	}
	
    /**
     * Get price of the food item.
     * @return foodPrice - Price of the food item.
     */
	public double getPrice() {
		return foodPrice;
	}
	
    /**
     * Gets the nutritional value of the food item.
     * @return foodNutrition - Nutritional value of food item.
     */
	public int getFoodNutrition() {
		return foodNutrition;
	}
	
    /**
     * Gets name of the food item.
     * @return foodName - Name of food item.
     */
	public String getFoodName() {
		return foodName;
	}
	
    /**
     * Gets the current amount of food items that are available.
     * @return quantity - quantity of food item.
     */
	public int getQuantity() {
		return quantity;
	}
	
    /**
     * Adds a food item to the current quantity.
     */
	public void addQuantity() {
		quantity +=1;
	}
	
    /**
     * Removes a food item from the current quantity.
     */
	public void subtractQuantity() {
		quantity -=1;
	}
}
