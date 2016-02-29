import static java.lang.Math.PI;

public class Circle {
	private String color = "red";
	private double radius;
	
	public Circle() {
		setRadius(1);
	}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}
}
