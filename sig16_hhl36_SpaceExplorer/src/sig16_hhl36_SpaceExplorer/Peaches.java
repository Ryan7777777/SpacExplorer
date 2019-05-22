package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Food_Item class.
 * A freeze dried peaches that are able to be consumed by crew members. 
 */
public class Peaches extends Food_Item {
	private static double price = 3.0;
	private static int nutrition = 8;
	private static String name = "Freeze Dried Peach";
	
    /**
     * Default constructor for freeze dried peaches.
     */
	public Peaches() {
		super(price, nutrition, name);
	}

}