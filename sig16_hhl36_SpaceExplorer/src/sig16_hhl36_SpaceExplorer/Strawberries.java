package sig16_hhl36_SpaceExplorer;

public class Strawberries extends Food_Item {
	public Strawberries() {
		super.Food_Item(1.5,4,"Freeze-Dried Whole Strawberries");
		super.toString();
	}
	public static void main(String arg[]) {
		Strawberries strawberries = new Strawberries();
		System.out.println(strawberries instanceof Food_Item);
		System.out.println(strawberries);
	}
}
