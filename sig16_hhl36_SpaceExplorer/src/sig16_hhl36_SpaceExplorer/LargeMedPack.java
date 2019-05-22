package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Medical_Item class.
 * A large med pack that can be used to increase health of crew member at a price. 
 */
public class LargeMedPack extends Medical_Item {
	private static double price = 5.0;
	private static int addHealth = 50;
	private static String name = "Large Med Pack";
	
    /**
     * Default constructor for large med pack.
     */
	public LargeMedPack() {
		super(price, addHealth, name);
	}
	
}