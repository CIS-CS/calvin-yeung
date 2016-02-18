/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zephyr
 */
public class Motorcycle extends Bicycle {
	private double fuel;
	
	public Motorcycle(String color, double mass, double fuel) {
		super(color, mass);
		setFuel(fuel);
	}
	
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	
	public double getFuel() {
		return fuel;
	}
	
	public void printDescription() {
		System.out.printf("A swaggering %s %f-kg bike with %fL of fuel. 52 more swags guaranteed.\n", getColor(), getMass(), getFuel());
	}
}
