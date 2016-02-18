public class WarBike extends Bicycle {
	private int ammo;
	
	public WarBike(String color, double mass, int ammo) {
		super(color, mass);
		setAmmo(ammo);
	}
	
	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public int getAmmo() {
		return ammo;
	}
	
	public void printDescription() {
		System.out.printf("A savage %s %f-kg bike for the bloodthirsty with %d ammo. Mars' favorite.\n", getColor(), getMass(), getAmmo());
	}
}
