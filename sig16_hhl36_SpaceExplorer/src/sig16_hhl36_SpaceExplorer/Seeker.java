package sig16_hhl36_SpaceExplorer;

public class Seeker extends CrewMenber{
	public Seeker() {
		super("name", "Hungy boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Seeker seeker = new Seeker();
		System.out.println(seeker instanceof CrewMenber);
		
	}
}
