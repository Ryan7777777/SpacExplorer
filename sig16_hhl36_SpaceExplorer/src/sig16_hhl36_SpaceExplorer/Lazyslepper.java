package sig16_hhl36_SpaceExplorer;

public class Lazyslepper extends CrewMenber{
	public void Lazyslepper() {
		super.CrewMenber("name", "Hungy boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Lazyslepper slepper = new Lazyslepper();
		System.out.println(slepper instanceof CrewMenber);
		
	}
}
