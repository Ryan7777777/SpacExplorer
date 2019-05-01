package sig16_hhl36_SpaceExplorer;

public class Technician extends CrewMenber{
	public void Technician() {
		super.CrewMenber("name", "Hungy boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Technician tech = new Technician();
		System.out.println(tech instanceof CrewMenber);
		
	}

}
