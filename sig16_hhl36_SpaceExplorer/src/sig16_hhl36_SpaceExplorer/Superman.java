package sig16_hhl36_SpaceExplorer;

public class Superman extends CrewMenber{
	public Superman() {
		super("name", "Hungy boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Superman superman = new Superman();
		System.out.println(superman instanceof CrewMenber);
	}
}
