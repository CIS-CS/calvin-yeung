public class Square extends Rectangle {
	private double side;
	
	public Square() {}
	
	public Square(double side) {
		setSide(side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
		setSide(side);
	}
	
	public void setSide(double side) {
		this.side = side;
	}
	
	public void setWidth(double side) {
		setSide(side);
	}
	
	public void setLength(double side) {
		setSide(side);
	}
}
