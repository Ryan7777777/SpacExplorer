package sig16_hhl36_SpaceExplorer;

/**
 * Implements a medical item class, used for events relating to medical items
 * available to be used by a crew member.
 */
public class MedicalItem {
	
	private double medItemPrice;
	private int medHealthAdd;
	private String medName;
	private int quantity;
	
    /**
     * Create a new medical item.
     * @param price - The price of the medical item.
     * @param addHealth - Amount of health given by medical item.
     * @param name - Name of the medical item
     */
	public MedicalItem(double price, int addHealth, String name) {
		medItemPrice = price;
		medHealthAdd = addHealth;
		medName = name;
	}
	
    /**
     * Get price of the medical item.
     * @return medItemPrice - Price of the medical item.
     */
	public double getPrice() {
		return medItemPrice;
	}
	
    /**
     * Gets the health value of the medical item.
     * @return medHealthAdd - health value of medical item.
     */
	public int getHealthAdd() {
		return medHealthAdd;
	}
	
    /**
     * Gets name of the medical item.
     * @return medName - Name of medical item.
     */
	public String getMedName() {
		return medName;
	}
	
    /**
     * Gets the current amount of medical items that are available.
     * @return quantity - quantity of medical item.
     */
	public int getQuantity() {
		return quantity;
	}
	
    /**
     * Adds a medical item to the current quantity.
     */
	public void addQuantity() {
		quantity += 1;
	}
	
    /**
     * Removes a medical item from the current quantity.
     */
	public void subtractQuantity() {
		quantity -= 1;
	}
}