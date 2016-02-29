public class Rectangle extends Shape {
	private double width = 1, length = 1;
	
	public Rectangle() {}
	
	public Rectangle(double width, double length) {
		setWidth(width);
		setLength(length);
	}
	
	public Rectangle(double width, double length, String color, boolean filled) {
		super(color, filled);
		
		setWidth(width);
		setLength(length);
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	public double getPerimeter() {
		return 2 * (width + length);
	}
	
	public double getArea() {
		return width * length;
	}
}
