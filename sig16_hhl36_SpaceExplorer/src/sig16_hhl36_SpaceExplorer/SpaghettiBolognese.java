package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Food_Item class.
 * A meal of dried spaghetti bolognese that is able to be consumed by crew members. 
 */
public class SpaghettiBolognese extends Food_Item{	
	private static double price = 7.0;
	private static int nutrition = 16;
	private static String name = "Dried Spaghetti Bolognese";
	
    /**
     * Default constructor for dried spaghetti bolognese.
     */
	public SpaghettiBolognese() {
		super(price, nutrition, name);
	}
	
}
