package sig16_hhl36_SpaceExplorer;

public class Superman extends CrewMember{
	public Superman() {
		super("name", "Superman", 4, 4, 4, "Everything is easy for him");
	}
	public static void main(String arg[]) {
		Superman superman = new Superman();
		System.out.println(superman instanceof CrewMember);
	}
}
