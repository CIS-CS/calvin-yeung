public class Shape {
	private String color = "red";
	private boolean filled = true;
	
	public Shape() {}
	
	public Shape(String color, boolean filled) {
		setColor(color);
		setFilled(filled);
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public String getColor() {
		return color;
	}
	
	public boolean isFilled() {
		return filled;
	}
}
