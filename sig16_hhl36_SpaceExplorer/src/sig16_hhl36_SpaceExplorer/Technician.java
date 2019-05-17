package sig16_hhl36_SpaceExplorer;

public class Technician extends CrewMember{
	public Technician() {
		super("name", "Technician", 10, 40, 4, "Good at repair");
	}
	public static void main(String arg[]) {
		Technician tech = new Technician();
		System.out.println(tech instanceof CrewMember);
		
	}

}
