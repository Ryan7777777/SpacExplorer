package sig16_hhl36_SpaceExplorer;

public class HungyBoy extends CrewMenber {
	public void HungyBoy() {
		super.CrewMenber("name", "Hungy boy", 10, 40, 4, "no");
	}
	public static void main(String arg[]) {
		HungyBoy boy = new HungyBoy();
		System.out.println(boy instanceof CrewMenber);
		
	}
}
