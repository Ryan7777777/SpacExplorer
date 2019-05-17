package sig16_hhl36_SpaceExplorer;

public class Hunk extends CrewMember{
	public Hunk() {
		super("name", "Hunk", 10, 40, 4, "Big and health");
	}
	public static void main(String arg[]) {
		Hunk hunk = new Hunk();
		System.out.println(hunk instanceof CrewMember);
	}

}
