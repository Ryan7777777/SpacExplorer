package sig16_hhl36_SpaceExplorer;

public class Seeker extends CrewMember{
	public Seeker() {
		super("name", "Seekrer", 10, 40, 4, "Inch-by-inch-search");
	}
	public static void main(String arg[]) {
		Seeker seeker = new Seeker();
		System.out.println(seeker instanceof CrewMember);
		
	}
}
