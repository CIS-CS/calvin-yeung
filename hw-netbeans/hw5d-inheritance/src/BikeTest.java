import java.util.ArrayList;

public class BikeTest {
	public static void main(String[] args) {
		ArrayList<Bicycle> bikes = new ArrayList<Bicycle>();
		
		bikes.add(new Bicycle("brown", 10));
		bikes.add(new LightBike("cyan", 5, 300000000));
		bikes.add(new WarBike("red", 50, 1000));
		bikes.add(new Motorcycle("pitch-black", 20, 50));
		
		// printDescription() is polymorphic
		for(Bicycle b : bikes)
			b.printDescription();
	}
}