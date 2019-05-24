package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Food_Item class.
 * Freeze dried whole strawberries that are able to be consumed by crew members. 
 */
public class Strawberries extends FoodItem {
	private static double price = 0.75;
	private static int nutrition = 4;
	private static String name = "Freeze-Dried Whole Strawberries";
	
    /**
     * Default constructor for freeze dried whole strawberries.
     */
	public Strawberries() {
		super(price, nutrition, name);
	}
	
}
