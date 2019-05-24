package sig16_hhl36_SpaceExplorer;

/**
 * Implemented class inherited by Medical_Item class.
 * A plague cure that can be used to increase health/get rid of plagued crew member at a price. 
 */
public class PlagueCure extends MedicalItem {
	private static double price = 10.0;
	private static int addHealth = 20;
	private static String name = "Space Plague Curer";
	
    /**
     * Default constructor for plague curer.
     */
	public PlagueCure(){
		super(price, addHealth, name);
	}

}