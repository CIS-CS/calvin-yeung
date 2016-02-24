import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class GreatPersonTest {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("resources/classes.txt"));
		ArrayList<Class<GreatPerson>> classes = new ArrayList<Class<GreatPerson>>();
		ArrayList<GreatPerson> gods = new ArrayList<GreatPerson>();
		
		while(scan.hasNext())
			classes.add((Class<GreatPerson>) Class.forName(scan.next()));
		
		for(Class<GreatPerson> c : classes)
			gods.add(c.newInstance());
		
		for(GreatPerson bob : gods) {
			System.out.println(bob.getClass().getName());
			bob.printAwesomeContributionsMayBeMoreThanOne();
			System.out.println(bob.getAwesomenessFactor() + "\n");
		}
		
		
	}
}
