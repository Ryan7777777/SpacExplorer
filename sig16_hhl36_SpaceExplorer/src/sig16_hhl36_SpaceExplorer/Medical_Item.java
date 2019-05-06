package sig16_hhl36_SpaceExplorer;

public class Medical_Item {
	
	private double medItemPrice;
	private int medHealthAdd;
	private String medName;
	
	public Medical_Item(double price, int addHealth, String name) {
		medItemPrice = price;
		medHealthAdd = addHealth;
		medName = name;
	}
	
	public double getPrice() {
		return medItemPrice;
	}
	
	public int getHealthAdd() {
		return medHealthAdd;
	}
	
	public String getMedName() {
		return medName;
	}
	
}