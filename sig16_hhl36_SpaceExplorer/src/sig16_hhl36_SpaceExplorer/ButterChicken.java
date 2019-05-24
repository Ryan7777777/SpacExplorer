package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Food_Item class.
 * A meal of freeze dried butter chicken that are able to be consumed by crew members. 
 */
public class ButterChicken extends FoodItem{
	private static double price = 7.0;
	private static int nutrition = 20;
	private static String name = "Freeze Dried Butter Chicken";
	
    /**
     * Default constructor for freeze dried butter chicken.
     */
	public ButterChicken() {
		super(price, nutrition, name);
	}

}
