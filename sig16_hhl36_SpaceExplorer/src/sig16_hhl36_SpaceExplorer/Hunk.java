package sig16_hhl36_SpaceExplorer;

public class Hunk extends CrewMember{
	public Hunk() {
		super("name", "Hunk", 5, 15, 8, "Big and health");
	}
	public static void main(String arg[]) {
		Hunk hunk = new Hunk();
		System.out.println(hunk instanceof CrewMember);
	}

}
