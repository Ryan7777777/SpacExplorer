package sig16_hhl36_SpaceExplorer;

public class Seeker extends CrewMember{
	public Seeker() {
		super("name", "Hungry boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Seeker seeker = new Seeker();
		System.out.println(seeker instanceof CrewMember);
		
	}
}
