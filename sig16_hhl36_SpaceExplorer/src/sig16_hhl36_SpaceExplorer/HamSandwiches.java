package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Food_Item class.
 * Ham sandwiches that are able to be consumed by crew members. 
 */
public class HamSandwiches extends Food_Item{
	private static double price = 4.5;
	private static int nutrition = 12;
	private static String name = "Ham Sandwiches";
	
	/**
	 * Default constructor for ham sandwiches
	 */
	public HamSandwiches() {
		super(price, nutrition, name);
	}

}
