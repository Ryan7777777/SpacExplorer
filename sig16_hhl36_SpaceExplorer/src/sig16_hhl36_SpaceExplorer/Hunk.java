package sig16_hhl36_SpaceExplorer;

public class Hunk extends CrewMember{
	public Hunk() {
		super("name", "Hungry boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Hunk hunk = new Hunk();
		System.out.println(hunk instanceof CrewMember);
	}

}
