package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Food_Item class.
 * Dried Bananas that are able to be consumed by crew members. 
 */
public class Banana extends Food_Item{
	private static double price = 3.0;
	private static int nutrition = 6;
	private static String name = "Dried Banana";
	/**
	 * Default constructor for dried bananas.
	 */
	public Banana() {
		super(price, nutrition, name);
	}

}
