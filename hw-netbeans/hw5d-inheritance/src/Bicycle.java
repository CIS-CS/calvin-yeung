public class Bicycle {
	private String color;
	private double mass;
	
	public Bicycle(String color, double mass) {
		setColor(color);
		setMass(mass);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	public String getColor() {
		return color;
	}
	
	public double getMass() {
		return mass;
	}
	
	public void printDescription() {
		System.out.printf("A mundane %s %f-kg bicycle that no one wants.\n", getColor(), getMass());
	}
}
