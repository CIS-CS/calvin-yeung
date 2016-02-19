import java.util.ArrayList;

public class GreatPersonTest {
	public static void main(String[] args) {
		ArrayList<GreatPerson> gods = new ArrayList<GreatPerson>();
		gods.add(new Einstein());
		gods.add(new Pythagoras());
		
		for(GreatPerson bob : gods) {
			System.out.println(bob.getClass().getName());
			bob.printAwesomeContributionsMayBeMoreThanOne();
			bob.printAwesomenessFactor();
			System.out.println();
		}
	}
}
