package sig16_hhl36_SpaceExplorer;

public class Food_Item {
	
	private double foodPrice;
	private int foodNutrition;
	private String foodName;
	
	public Food_Item(double price, int nutrition, String name) {
		foodPrice = price;
		foodNutrition = nutrition;
		foodName = name;
	}
	
	public double getPrice() {
		return foodPrice;
	}
	
	public int getFoodNutrition() {
		return foodNutrition;
	}
	
	public String getMedName() {
		return foodName;
	}
	
}
