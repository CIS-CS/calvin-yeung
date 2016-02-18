public class LightBike extends Bicycle {
	private double maxSpeed;
	
	public LightBike(String color, double mass, double maxSpeed) {
		super(color, mass);
		setMaxSpeed(maxSpeed);
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void printDescription() {
		System.out.printf("A speedy %s %f-kg lightbike that can travel at %f km/h. A thrilling ride.\n", getColor(), getMass(), getMaxSpeed());
	}
}
