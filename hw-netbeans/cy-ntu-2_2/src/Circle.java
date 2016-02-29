import static java.lang.Math.PI;

public class Circle extends Shape {
	private double radius = 1.0;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		setRadius(radius);
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getPerimeter() {
		return 2 * PI * radius;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}
}
