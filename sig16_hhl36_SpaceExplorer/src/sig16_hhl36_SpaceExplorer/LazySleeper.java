package sig16_hhl36_SpaceExplorer;

public class LazySleeper extends CrewMember{
	public LazySleeper() {
		super("name", "LazySlepper", 10, 10, 20, "ZZZzzzZZZzzz!");
	}
	public static void main(String arg[]) {
		LazySleeper slepper = new LazySleeper();
		System.out.println(slepper instanceof CrewMember);
		
	}
}
