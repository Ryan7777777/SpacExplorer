package sig16_hhl36_SpaceExplorer;

public class Food_Item {
	
	private double foodPrice;
	private int foodNutrition;
	private String foodName;
	private int quantity;
	
	public Food_Item(double price, int nutrition, String name) {
		foodPrice = price;
		foodNutrition = nutrition;
		foodName = name;
		quantity = 0;
	}
	
	public double getPrice() {
		return foodPrice;
	}
	
	public int getFoodNutrition() {
		return foodNutrition;
	}
	
	public String getFoodName() {
		return foodName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void addQuantity() {
		quantity +=1;
	}
	public void subtractQuantity() {
		quantity -=1;
	}
}
