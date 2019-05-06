package sig16_hhl36_SpaceExplorer;

public class Hunk extends CrewMenber{
	public void Hunk() {
		super.CrewMenber("name", "Hungy boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		Hunk hunk = new Hunk();
		System.out.println(hunk instanceof CrewMenber);
		
	}

}
