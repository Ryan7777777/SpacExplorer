package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Medical_Item class.
 * A small med pack that can be used to increase health of crew member at a price. 
 */
public class SmallMedPack extends Medical_Item {
	private static double price = 2.4;
	private static int addHealth = 25;
	private static String name = "Small Med Pack";
	
    /**
     * Default constructor for small med pack.
     */
	public SmallMedPack() {
		super(price, addHealth, name);
	}
}